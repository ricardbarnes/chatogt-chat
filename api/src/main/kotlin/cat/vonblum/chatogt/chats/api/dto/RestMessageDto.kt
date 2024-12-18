package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestMessageDto(
    val id: UUID,
    val chatId: UUID,
    val content: String,
    val status: String
)