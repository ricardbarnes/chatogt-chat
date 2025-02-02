package cat.vonblum.chatogt.chats.users.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import java.util.UUID

class CreateUserCommand(
    val name: String,
    val password: String
) : Command