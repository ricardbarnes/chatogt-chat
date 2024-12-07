package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import java.util.UUID

class FindMessageQuery(private val id: UUID) : Query {

    fun id(): UUID = id

}