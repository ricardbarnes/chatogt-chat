package cat.vonblum.chatogt.chats.chats.delete

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.*

class DeleteChatCommand(val id: UUID) : Command