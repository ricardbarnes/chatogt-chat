package cat.vonblum.chatogt.chats.chat

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.time.Instant
import java.util.*

class ChatMutedEvent(
    override val aggregateId: UUID,
    override var id: UUID = UUID.randomUUID(),
    override val occurredOn: Instant = Instant.now()
) : Event