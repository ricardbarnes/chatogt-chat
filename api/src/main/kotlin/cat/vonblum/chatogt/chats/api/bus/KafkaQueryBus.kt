package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.api.mapper.KafkaChatQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaUserQueryMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeaders
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

@DriverAdapter
@Component
class KafkaQueryBus(
    private val chatMapper: KafkaChatQueryMapper,
    private val userMapper: KafkaUserQueryMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.queries}") private val queriesTopic: String,
) : QueryBus {

    private val responseFutures = ConcurrentHashMap<UUID, CompletableFuture<ConsumerRecord<UUID, String>>>()

    override fun ask(query: Query): Response? {
        return when (query) {
            is FindChatIdsByUserIdQuery -> askFindChatsByUserIdQuery(query)
            is FindChatQuery -> askFindChatQuery(query)
            else -> null
        }
    }

    private fun askFindChatsByUserIdQuery(query: FindChatIdsByUserIdQuery): Response? {
        val correlationId = UUID.randomUUID()
        val future = CompletableFuture<ConsumerRecord<UUID, String>>()
        responseFutures[correlationId] = future

        val headers = RecordHeaders().apply {
            add("type", query::class.qualifiedName?.toByteArray())
            add("correlationId", correlationId.toString().toByteArray())
        }

        val record = ProducerRecord(
            queriesTopic,
            null,
            query.userId,
            userMapper.toDto(query),
            headers
        )

        // Send request
        producer.send(record)

        return try {
            // Wait for the response
            val responseRecord = future.get(30, TimeUnit.SECONDS)
            chatMapper.toFindChatIdsByUserIdResponse(responseRecord.value())
        } catch (e: Exception) {
            // Handle timeout or other exceptions
            throw RuntimeException("Failed to get response for query", e)
        } finally {
            // Clean up the future
            responseFutures.remove(correlationId)
        }
    }

    private fun askFindChatQuery(query: FindChatQuery): Response? {
        val correlationId = UUID.randomUUID()
        val future = CompletableFuture<ConsumerRecord<UUID, String>>()
        responseFutures[correlationId] = future

        val headers = RecordHeaders().apply {
            add("type", query::class.qualifiedName?.toByteArray())
            add("correlationId", correlationId.toString().toByteArray())
        }

        val record = ProducerRecord(
            queriesTopic,
            null,
            query.id,
            userMapper.toDto(query),
            headers
        )

        // Send request
        producer.send(record)

        return try {
            // Wait for the response
            val responseRecord = future.get(30, TimeUnit.SECONDS)
            chatMapper.toFindChatQuery(responseRecord.value())
        } catch (e: Exception) {
            // Handle timeout or other exceptions
            throw RuntimeException("Failed to get response for query", e)
        } finally {
            // Clean up the future
            responseFutures.remove(correlationId)
        }
    }

    @KafkaListener(topics = ["\${kafka.topics.responses}"], groupId = "vonblum")
    private fun listenResponse(record: ConsumerRecord<UUID, String>) {
        val rawCorrelationId = record.headers().lastHeader("correlationId")?.value()
        val correlationId = rawCorrelationId?.let { UUID.fromString(String(it)) }
        if (correlationId != null) {
            responseFutures[correlationId]?.complete(record)
        }
    }

}
