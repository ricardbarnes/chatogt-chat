package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestChatDto(
    private val id: UUID,
    private val userId: UUID,
    private val status: String = "CREATED"
) {

    fun id(): UUID = id

    fun userId(): UUID = userId

    fun status(): String = status

}