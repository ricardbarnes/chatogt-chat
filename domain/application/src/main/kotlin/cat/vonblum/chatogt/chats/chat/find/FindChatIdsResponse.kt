package cat.vonblum.chatogt.chats.chat.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindChatIdsResponse(
    private val userId: UUID,
    private val chatIds: List<UUID>,
) : Response {

    fun userId(): UUID = userId

    fun chatIds(): List<UUID> = chatIds

}