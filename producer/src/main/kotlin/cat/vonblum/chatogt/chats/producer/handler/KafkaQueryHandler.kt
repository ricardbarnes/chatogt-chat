package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chats.find.FindChatsByUserIdHandler
import cat.vonblum.chatogt.chats.chats.find.FindChatsByUserIdQuery
import cat.vonblum.chatogt.chats.producer.mapper.KafkaQueryMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import cat.vonblum.chatogt.chats.users.find.FindUserQueryHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val findUserQueryHandler: FindUserQueryHandler,
    private val findChatsByUserIdQuery: FindChatsByUserIdHandler,
) {

    @KafkaListener(topics = ["\${kafka.topics.queries}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val typeName = record.headers().lastHeader("type")?.value()?.let { String(it) }
        val type = Class.forName(typeName).kotlin

        when (type) {
            FindUserQuery::class -> {
                val response = findUserQueryHandler.handle(mapper.toFindUserQuery(record.value()))
                // TODO send response back
            }

            FindChatsByUserIdQuery::class -> {
                val response = findChatsByUserIdQuery.handle(mapper.toFindChatsByUserId(record.value()))
                // TODO send response back
            }
        }

    }

}