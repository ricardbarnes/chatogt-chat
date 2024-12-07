package cat.vonblum.chatogt.chats.chat.find

import cat.vonblum.chatogt.chats.chat.ChatRepository
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindChatIdsQueryHandler(private val repository: ChatRepository) : QueryHandler {

    fun handle(query: FindChatIdsQuery): FindChatIdsResponse =
        FindChatIdsResponse(
            query.userId(),
            repository.findAllIdsByUserId(UserId(query.userId())).map { it.value }
        )

}