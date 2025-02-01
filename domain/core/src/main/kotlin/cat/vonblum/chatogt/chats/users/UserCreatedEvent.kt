package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserCreatedEvent(
    aggregateId: UUID,
    name: String,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)