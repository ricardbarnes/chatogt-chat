package cat.vonblum.chatogt.users.users.find

import cat.vonblum.chatogt.chats.shared.domain.query.Response
import java.util.UUID

class FindUserByNameResponse(
    val id: UUID,
    val name: String,
    val role: String
) : Response