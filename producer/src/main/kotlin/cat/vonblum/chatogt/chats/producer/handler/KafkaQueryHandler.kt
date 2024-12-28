package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.producer.mapper.KafkaQueryMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import cat.vonblum.chatogt.chats.users.find.FindUserQueryHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaQueryHandler(
    private val mapper: KafkaQueryMapper,
    private val handler: FindUserQueryHandler // TODO...
) {

    @KafkaListener(topics = ["\${kafka.topics.queries}"])
    fun handle(record: ConsumerRecord<UUID, String>) = handler.handle(mapper.toFindUserQuery(record.value()))

}