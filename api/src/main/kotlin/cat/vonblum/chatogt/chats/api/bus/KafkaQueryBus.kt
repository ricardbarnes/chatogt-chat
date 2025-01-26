package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.api.mapper.KafkaChatQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaMessageQueryMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaUserQueryMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeaders
import org.apache.kafka.common.protocol.types.Field.Str
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaQueryBus(
    private val chatMapper: KafkaChatQueryMapper,
    private val messageMapper: KafkaMessageQueryMapper,
    private val userMapper: KafkaUserQueryMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.queries}") private val queriesTopic: String,
    @Value("\${kafka.topics.responses}") private val responsesTopic: String
) : QueryBus {

    private var currentCorrelationId: UUID? = null
    private var receivedResponseRecord: ConsumerRecord<UUID, String>? = null

    override fun ask(query: Query): Response? {
        return when (query) {
            is FindChatIdsByUserIdQuery -> askFindChatsByUserIdQuery(query)
            else -> null
        }
    }

    private fun askFindChatsByUserIdQuery(query: FindChatIdsByUserIdQuery): Response? { // TODO
        val correlationId = UUID.randomUUID()
        currentCorrelationId = correlationId
        val headers = RecordHeaders()
        headers.add("type", query::class.qualifiedName?.toByteArray())
        headers.add("correlationId", correlationId.toString().toByteArray())
        val record = ProducerRecord(
            queriesTopic,
            null,
            query.userId,
            userMapper.toDto(query),
            headers
        )

        // Send request
        producer.send(record)

        Thread.sleep(5000)

        // Return response
        return chatMapper.toDomain(receivedResponseRecord?.value())
    }

    @KafkaListener(topics = ["\${kafka.topics.responses}"], groupId = "vonblum")
    private fun listenResponse(record: ConsumerRecord<UUID, String>) {
        val rawCorrelationId = record.headers().lastHeader("correlationId")?.value()
        val recordCorrelationId = UUID.fromString(rawCorrelationId?.let { String(it) })
        if (recordCorrelationId == currentCorrelationId) {
            receivedResponseRecord = record
        }
    }

}