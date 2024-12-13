package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.command.KafkaCreateChatCommand
import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import org.springframework.stereotype.Component

@Component
class KafkaChatCommandMapper {

    fun toDto(command: CreateChatCommand): KafkaCreateChatCommand =
        KafkaCreateChatCommand(
            command.id(),
            command.userId()
        )

}