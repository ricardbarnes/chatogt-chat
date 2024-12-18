package cat.vonblum.chatogt.chats.messages.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessagesResponse(
    val chatId: UUID,
    val messages: List<Map<String, String>>
) : Response