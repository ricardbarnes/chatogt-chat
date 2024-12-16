package cat.vonblum.chatogt.chats.chat.delete

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.*

class DeleteChatCommand(val id: UUID) : Command