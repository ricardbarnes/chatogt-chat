package cat.vonblum.chatogt.chats.messages.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class CreateMessageCommand(
    val id: UUID,
    val chatId: UUID,
    val authorId: UUID,
    val content: String
) : Command