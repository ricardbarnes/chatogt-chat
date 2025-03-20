package cat.vonblum.chatogt.users.users

import cat.vonblum.chatogt.chats.shared.domain.valueobject.Id
import java.util.UUID

class UserId(override val value: UUID) : Id(value) {
}