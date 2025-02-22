package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindChatIdsByUserIdQueryHandler(private val finding: FindingChats) : QueryHandler {

    fun handle(query: FindChatIdsByUserIdQuery) =
        FindChatIdsByUserIdResponse(
            query.userId,
            finding.findAllIdsByUserId(UserId(query.userId)).stream().map { it.value }.toList()
        )

}