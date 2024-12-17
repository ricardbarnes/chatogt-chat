package cat.vonblum.chatogt.chats.user.delete

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class DeleteUserCommand(val id: UUID) : Command