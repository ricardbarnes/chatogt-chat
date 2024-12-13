package cat.vonblum.chatogt.chats.producer.deserializer

import cat.vonblum.chatogt.chats.shared.infrastructure.command.KafkaCreateChatCommand
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets
import java.util.*

class KafkaCreateChatCommandDeserializer : Deserializer<KafkaCreateChatCommand> {

    override fun deserialize(topic: String, data: ByteArray): KafkaCreateChatCommand {
        val stringData = String(data, StandardCharsets.UTF_8)
        val parts = stringData.split(" ")
        val id = UUID.fromString(parts[0])
        val userId = UUID.fromString(parts[1])
        return KafkaCreateChatCommand(id, userId)
    }

}