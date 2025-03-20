package cat.vonblum.chatogt.users.users.delete

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class DeleteUserByIdCommand(val id: UUID) : Command