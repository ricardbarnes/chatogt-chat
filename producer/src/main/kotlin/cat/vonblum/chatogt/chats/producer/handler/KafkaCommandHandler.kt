package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.producer.mapper.KafkaCommandMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaCommandHandler(
    private val mapper: KafkaCommandMapper,
    private val handler: CreateChatCommandHandler
) {

    @KafkaListener(topics = ["\${kafka.topics.commands}"])
    fun handle(record: ConsumerRecord<UUID, String>) = handler.handle(mapper.toDomain(record.value()))

}