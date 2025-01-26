package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdHandler
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.producer.mapper.KafkaQueryMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val findChatsByUserIdQuery: FindChatIdsByUserIdHandler,
) {

    @KafkaListener(topics = ["\${kafka.topics.queries}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val typeName = record.headers().lastHeader("type")?.value()?.let { String(it) }
        val type = Class.forName(typeName).kotlin

        when (type) {
            FindChatIdsByUserIdQuery::class -> {
                val response = findChatsByUserIdQuery.handle(mapper.toFindChatsByUserId(record.value()))
                // TODO send response back
            }
        }

    }

}