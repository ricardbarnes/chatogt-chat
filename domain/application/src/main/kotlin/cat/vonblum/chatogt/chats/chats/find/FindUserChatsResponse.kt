package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindUserChatsResponse(
    val userId: UUID,
    val chatIds: List<UUID>
) : Response