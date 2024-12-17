package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessageResponse(
    val id: UUID,
    val content: String
) : Response