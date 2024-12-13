package cat.vonblum.chatogt.chats.chat.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class UpdateChatCommand(private val id: UUID, private val status: String) : Command {

    fun id(): UUID = id

    fun status(): String = status

}