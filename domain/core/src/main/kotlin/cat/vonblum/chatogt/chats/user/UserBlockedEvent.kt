package cat.vonblum.chatogt.chats.user

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.time.Instant
import java.util.UUID

class UserBlockedEvent(
    val blockedId: UUID,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now(),
) : Event(aggregateId, id, occurredOn)