package cat.vonblum.chatogt.chats.api.command

import java.util.UUID

class KafkaCreateChatCommand(
    private val id: UUID,
    private val userId: UUID,
) {

    fun id(): UUID = id

    fun userId(): UUID = userId

}