package cat.vonblum.chatogt.chats.message.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindMessageIdsResponse(
    val chatId: UUID,
    val messageIds: List<UUID>,
) : Response