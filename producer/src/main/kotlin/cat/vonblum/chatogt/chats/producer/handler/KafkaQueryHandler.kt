package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chats.find.FindChatQueryHandler
import cat.vonblum.chatogt.chats.producer.mapper.KafkaQueryMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.UUID

@DriverAdapter
@Component
class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val handler: FindChatQueryHandler
) {

    @KafkaListener(topics = ["\${kafka.topics.queries}"])
    fun handle(record: ConsumerRecord<UUID, String>) = handler.handle(mapper.toFindChatQuery(record.value()))

}