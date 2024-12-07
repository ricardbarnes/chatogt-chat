package cat.vonblum.chatogt.chats.chat.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.*

class CreateChatCommand(
    private val id: UUID,
    private val userId: UUID,
) : Command {

    fun id(): UUID = id

    fun userId(): UUID = userId

}