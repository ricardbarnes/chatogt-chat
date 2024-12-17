package cat.vonblum.chatogt.chats.messages.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class UpdateMessageCommand(
    val id: UUID,
    val content: String
) : Command