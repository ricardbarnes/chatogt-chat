package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.chats.ChatRepository
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindChatQueryHandler(private val repository: ChatRepository) : QueryHandler {

    fun handle(query: FindChatQuery): FindChatResponse =
        FindChatResponse(
            query.id,
            repository.findAllIdsByUserId(UserId(query.id)).map { it.value }
        )

}