package cat.vonblum.chatogt.chats.users.find

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.users.FindingUsers

class FindUserQueryHandler(private val finding: FindingUsers) {

    fun handle(query: FindUserQuery): FindUserResponse =
        FindUserResponse(finding.findById(UserId(query.id)).id.value)

}