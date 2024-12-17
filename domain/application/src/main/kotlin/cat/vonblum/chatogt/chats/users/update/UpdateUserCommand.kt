package cat.vonblum.chatogt.chats.users.update

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class UpdateUserCommand(
    val chatIds: List<UUID>,
    val blockedIds: List<UUID>,
) : Command