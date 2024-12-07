package cat.vonblum.chatogt.chats.message.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class UpdateMessageCommand(
    private val id: UUID,
    private val content: String
) : Command {

    fun id(): UUID = id

    fun content(): String = content

}