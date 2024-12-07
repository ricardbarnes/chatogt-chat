package cat.vonblum.chatogt.chats.shared

import cat.vonblum.chatogt.chats.shared.domain.valueobject.Id
import java.util.UUID

class UserId(override val value: UUID) : Id(value)