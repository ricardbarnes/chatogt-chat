package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.api.mapper.KafkaChatQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaMessageQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaUserQueryMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.Headers
import org.apache.kafka.common.header.internals.RecordHeaders
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass

@DriverAdapter
@Component
class KafkaQueryBus(
    private val chatMapper: KafkaChatQueryMapper,
    private val messageMapper: KafkaMessageQueryMapper,
    private val userMapper: KafkaUserQueryMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.queries}") private val topic: String,
    @Value("\${kafka.topics.responses}") private val responseTopic: String
) : QueryBus {

    private val responseFutures: MutableMap<String, CompletableFuture<String>> = mutableMapOf()

    override fun ask(query: Query): Response? {
        return when (query) {
            is FindUserQuery -> askFindUserQuery(query)
            is FindChatIdsByUserIdQuery -> askFindChatsByUserIdQuery(query)
            else -> null // TODO...
        }
    }

    private fun aHeaders(clazz: KClass<*>): Headers {
        val headers = RecordHeaders()
        headers.add("type", clazz.qualifiedName?.toByteArray())
        return headers
    }

    private fun askFindUserQuery(query: FindUserQuery): Response? { // TODO...
        val correlationId = UUID.randomUUID().toString()

        // Send request
        producer.send(
            ProducerRecord(
                topic,
                null,
                query.id,
                userMapper.toDto(query),
                aHeaders(query::class)
            )
        )

        // Wait for response
        val responseFuture = CompletableFuture<String>()
        responseFutures[correlationId] = responseFuture
        val response = responseFuture.get()

        // Clean up futures
        responseFutures.remove(correlationId)?.complete(response)

        // Return response
        return chatMapper.toDomain(response)
    }

    private fun askFindChatsByUserIdQuery(query: FindChatIdsByUserIdQuery): Response? { // TODO
        val correlationId = UUID.randomUUID().toString()

        // Send request
        producer.send(
            ProducerRecord(
                topic,
                null,
                query.userId,
                userMapper.toDto(query),
                aHeaders(query::class)
            )
        )

        // Wait for response
        val responseFuture = CompletableFuture<String>()
        responseFutures[correlationId] = responseFuture
        val response = responseFuture.get()

        // Clean up futures
        responseFutures.remove(correlationId)?.complete(response)

        // Return response
        return chatMapper.toDomain(response)
    }

}