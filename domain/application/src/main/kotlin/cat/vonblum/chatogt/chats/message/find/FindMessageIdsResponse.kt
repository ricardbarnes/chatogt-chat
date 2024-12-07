package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessageIdsResponse(
    private val chatId: UUID,
    private val messageIds: List<UUID>,
) : Response {

    fun chatId(): UUID = chatId

    fun messageIds(): List<UUID> = messageIds

}