package cat.vonblum.chatogt.chats.shared

import cat.vonblum.chatogt.chats.shared.domain.valueobject.Id
import java.util.*

class ChatId(override val value: UUID) : Id(value)