package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.MessageRepository
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindMessageQueryHandler(private val repository: MessageRepository) : QueryHandler {

    fun handle(query: FindMessageQuery): FindMessageResponse =
        FindMessageResponse(
            query.id,
            repository.findById(MessageId(query.id)).content.value()
        )

}