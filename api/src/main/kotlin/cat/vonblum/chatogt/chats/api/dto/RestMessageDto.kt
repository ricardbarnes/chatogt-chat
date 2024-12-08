package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestMessageDto(
    private val id: UUID,
    private val chatId: UUID,
    private var content: String,
    private var status: String
)