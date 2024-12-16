package cat.vonblum.chatogt.chats.chat.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindChatIdsResponse(
    val userId: UUID,
    val chatIds: List<UUID>,
) : Response