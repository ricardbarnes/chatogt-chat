package cat.vonblum.chatogt.chats.message.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class CreateMessageCommand(
    private val id: UUID,
    private val chatId: UUID,
    private val content: String
) : Command {

    fun id(): UUID = id

    fun chatId(): UUID = chatId

    fun content(): String = content

}