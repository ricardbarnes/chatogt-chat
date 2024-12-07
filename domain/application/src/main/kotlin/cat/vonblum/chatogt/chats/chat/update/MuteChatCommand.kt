package cat.vonblum.chatogt.chats.chat.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class MuteChatCommand(private val id: UUID) : Command {

    fun id(): UUID = id

}