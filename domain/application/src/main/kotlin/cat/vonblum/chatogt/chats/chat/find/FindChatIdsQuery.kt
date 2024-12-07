package cat.vonblum.chatogt.chats.chat.find

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import java.util.UUID

class FindChatIdsQuery(private val userId: UUID) : Query {

    fun userId(): UUID = userId

}