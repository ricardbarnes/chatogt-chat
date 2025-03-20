package cat.vonblum.chatogt.users.users.create

import cat.vonblum.chatogt.chats.shared.domain.command.Command

class CreateUserCommand(
    val name: String,
    val password: String,
    val role: String
) : Command