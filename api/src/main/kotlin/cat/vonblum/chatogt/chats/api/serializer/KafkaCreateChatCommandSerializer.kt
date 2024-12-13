package cat.vonblum.chatogt.chats.api.serializer

import cat.vonblum.chatogt.chats.api.command.KafkaCreateChatCommand
import org.apache.kafka.common.serialization.Serializer

class KafkaCreateChatCommandSerializer : Serializer<KafkaCreateChatCommand> {

    override fun serialize(topic: String, data: KafkaCreateChatCommand): ByteArray =
        data.id().toString().toByteArray() + data.userId().toString().toByteArray()

}