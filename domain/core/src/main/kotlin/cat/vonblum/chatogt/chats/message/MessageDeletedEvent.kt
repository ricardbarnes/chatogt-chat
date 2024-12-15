package cat.vonblum.chatogt.chats.message

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.time.Instant
import java.util.*

class MessageDeletedEvent(
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn)