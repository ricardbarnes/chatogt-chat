package cat.vonblum.chatogt.chats.chats.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class UpdateChatCommand(
    val id: UUID,
    val status: String
) : Command