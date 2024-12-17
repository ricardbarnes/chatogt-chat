package cat.vonblum.chatogt.chats.chats.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.*

class CreateChatCommand(
    val id: UUID,
    val userId: UUID,
) : Command