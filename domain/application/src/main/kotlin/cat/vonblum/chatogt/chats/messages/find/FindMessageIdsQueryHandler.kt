package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.query.QueryHandler

class FindMessageIdsQueryHandler(private val finding: FindingMessages) : QueryHandler {

    fun handle(query: FindMessageIdsQuery): FindMessagesResponse =
        FindMessagesResponse(
            query.chatId,
            finding.findAllByChatId(ChatId(query.chatId)).map {
                mapOf(
                    "id" to it.id.value.toString(),
                    "content" to it.content.value,
                    "status" to it.status.name
                )
            }
        )

}