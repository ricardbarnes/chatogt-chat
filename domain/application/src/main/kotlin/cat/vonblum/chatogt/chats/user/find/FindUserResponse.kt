package cat.vonblum.chatogt.chats.user.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.*

class FindUserResponse(
    val id: UUID,
    val chatIds: List<UUID>,
    val blockedIds: List<UUID>,
) : Response