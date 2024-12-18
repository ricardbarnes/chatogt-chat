package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindChatQueryHandler(private val finding: FindingChats) : QueryHandler {

    fun handle(query: FindChatQuery): FindChatResponse =
        FindChatResponse(
            query.id,
            finding.findAllByUserId(UserId(query.id)).map { it.value }
        )

}