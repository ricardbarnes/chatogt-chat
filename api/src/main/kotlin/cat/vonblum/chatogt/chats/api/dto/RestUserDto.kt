package cat.vonblum.chatogt.chats.api.dto

import java.util.UUID

class RestUserDto(
    val id: UUID,
    val chatIds: List<UUID>,
    val blockedIds: List<UUID>
)