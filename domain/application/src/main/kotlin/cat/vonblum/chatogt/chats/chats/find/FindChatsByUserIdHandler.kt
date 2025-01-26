package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindChatsByUserIdHandler(private val finding: FindingChats) : QueryHandler {

    fun handle(query: FindChatsByUserIdQuery) =
        FindChatsByUserIdResponse(
            query.userId,
            finding.findAllByUserId(UserId(query.userId)).stream().map { it.id.value }.toList()
        )

}