package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindChatResponse(
    val id: UUID,
    val participantIds: List<UUID>
) : Response