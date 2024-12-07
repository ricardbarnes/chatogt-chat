package cat.vonblum.chatogt.chats.message.delete

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class DeleteMessageCommand(private val id: UUID) : Command {

    fun id(): UUID = id

}