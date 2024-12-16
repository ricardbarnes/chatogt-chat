package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessageResponse(
    val id: UUID,
    val content: String
) : Response