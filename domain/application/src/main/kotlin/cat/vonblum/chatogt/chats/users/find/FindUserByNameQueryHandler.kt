package cat.vonblum.chatogt.chats.users.find

import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.users.FindingUsers
import cat.vonblum.chatogt.chats.users.UserName

class FindUserByNameQueryHandler(private val finding: FindingUsers) : CommandHandler {

    fun handle(query: FindUserByNameQuery): FindUserByNameResponse =
        finding.findByName(UserName(query.name)).let { user ->
            FindUserByNameResponse(
                user.id.value,
                user.name.value
            )
        }

}