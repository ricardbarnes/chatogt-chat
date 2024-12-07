package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessageResponse(
    private val id: UUID,
    private val content: String
) : Response {

    fun id(): UUID = id

    fun content(): String = content

}