package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.shared.infrastructure.command.KafkaCreateChatCommand
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class KafkaCreateChatCommandHandler {

    @KafkaListener(
        topics = ["\${kafka.topics.commands}"],
        groupId = "chat-command-group"
    )
    fun handle(record: ConsumerRecord<UUID, KafkaCreateChatCommand>) {
        println("Message with key: ${record.key()} and value: ${record.value()}")
    }

}