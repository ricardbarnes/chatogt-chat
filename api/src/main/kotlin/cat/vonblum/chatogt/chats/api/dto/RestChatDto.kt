package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestChatDto(
    val id: UUID,
    val userId: UUID,
    val status: String
)