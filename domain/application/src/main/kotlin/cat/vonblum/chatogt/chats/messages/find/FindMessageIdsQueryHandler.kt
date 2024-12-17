package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.messages.MessageRepository
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindMessageIdsQueryHandler(private val repository: MessageRepository) : QueryHandler {

    fun handle(query: FindMessageIdsQuery): FindMessageIdsResponse =
        FindMessageIdsResponse(
            query.chatId,
            repository.findAllIdsByChatId(ChatId(query.chatId)).map { it.value }
        )

}