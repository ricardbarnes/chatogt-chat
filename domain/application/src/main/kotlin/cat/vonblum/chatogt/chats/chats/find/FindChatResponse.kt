package cat.vonblum.chatogt.chats.chats.find

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

@Suppress("unused")
@UsedBy("handler")
class FindChatResponse(
    val userId: UUID,
    val chatIds: List<UUID>,
) : Response