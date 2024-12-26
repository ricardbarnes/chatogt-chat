package cat.vonblum.chatogt.chats.users.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.*

class FindUserResponse(
    val id: UUID,
    val chatIds: List<UUID>
) : Response