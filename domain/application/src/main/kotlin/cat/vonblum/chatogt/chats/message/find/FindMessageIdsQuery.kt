package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import java.util.UUID

class FindMessageIdsQuery(private val chatId: UUID) : Query {

    fun chatId(): UUID = chatId

}