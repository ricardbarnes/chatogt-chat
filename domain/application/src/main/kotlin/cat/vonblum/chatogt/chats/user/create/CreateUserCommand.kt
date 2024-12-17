package cat.vonblum.chatogt.chats.user.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class CreateUserCommand(
    val id: UUID,
    val chatIds: List<UUID>,
    val blockedIds: List<UUID>,
) : Command