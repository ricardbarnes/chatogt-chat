package cat.vonblum.chatogt.chats.api.dto

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.UUID

class RestUserDto @JsonCreator constructor(
    val id: UUID,
    val chatIds: List<String>,
)