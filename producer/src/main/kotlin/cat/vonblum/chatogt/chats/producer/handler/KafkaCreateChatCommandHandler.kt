package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chat.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.producer.mapper.KafkaCommandMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaCreateChatCommandHandler(
    private val mapper: KafkaCommandMapper,
    private val handler: CreateChatCommandHandler
) {

    @KafkaListener(topics = ["\${kafka.topics.commands}"],)
    fun handle(record: ConsumerRecord<UUID, String>) {
        handler.handle(mapper.toDomain(record.value()))
    }

}