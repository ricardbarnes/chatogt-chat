package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import com.google.gson.Gson
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class KafkaCreateChatCommandHandler(private val gson: Gson) {

    @KafkaListener(
        topics = ["\${kafka.topics.commands}"],
        groupId = "\${kafka.group.id}"
    )
    fun handle(record: ConsumerRecord<UUID, String>) {
        val value = record.value()
        val deserializedMessage = gson.fromJson(value, CreateChatCommand::class.java)
        println(deserializedMessage)
    }

}