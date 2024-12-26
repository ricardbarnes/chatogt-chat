package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.api.mapper.KafkaChatQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaMessageQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaUserQueryMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.concurrent.CompletableFuture

@DriverAdapter
@Component
class KafkaQueryBus(
    private val chatMapper: KafkaChatQueryMapper,
    private val messageMapper: KafkaMessageQueryMapper,
    private val userMapper: KafkaUserQueryMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.queries}") private val queryTopic: String,
    @Value("\${kafka.topics.responses}") private val responseTopic: String
) : QueryBus {

    private val responseFutures: MutableMap<String, CompletableFuture<Response>> = mutableMapOf()

    override fun ask(query: Query): Response? {
        return when (query) {
            is FindChatQuery -> askFindChatQuery(query)
            else -> null // TODO...
        }
    }

    private fun askFindChatQuery(query: FindChatQuery): Response? { // TODO refactor
        val correlationId = UUID.randomUUID().toString()

        // Send request
        producer.send(
            ProducerRecord(
                queryTopic,
                query.id,
                chatMapper.toDto(query)
            )
        )

        // Wait for response
        val responseFuture = CompletableFuture<Response>()
        responseFutures[correlationId] = responseFuture
        val response = responseFuture.get()

        // Clean up futures
        responseFutures.remove(correlationId)?.complete(response)

        // Return response
        return response;
    }

}