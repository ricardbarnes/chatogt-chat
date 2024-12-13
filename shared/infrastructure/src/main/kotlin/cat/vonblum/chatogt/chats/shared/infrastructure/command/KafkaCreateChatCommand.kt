package cat.vonblum.chatogt.chats.shared.infrastructure.command

import java.util.UUID

class KafkaCreateChatCommand(
    private val id: UUID,
    private val userId: UUID,
) {

    fun id(): UUID = id

    fun userId(): UUID = userId

}