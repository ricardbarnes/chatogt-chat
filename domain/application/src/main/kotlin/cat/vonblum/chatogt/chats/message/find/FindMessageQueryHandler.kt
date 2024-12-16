package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.message.MessageId
import cat.vonblum.chatogt.chats.message.MessageRepository
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindMessageQueryHandler(private val repository: MessageRepository) : QueryHandler {

    fun handle(query: FindMessageQuery): FindMessageResponse =
        FindMessageResponse(
            query.id,
            repository.findById(MessageId(query.id)).content().value()
        )

}