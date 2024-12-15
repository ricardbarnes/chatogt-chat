package cat.vonblum.chatogt.chats.chat

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.time.Instant
import java.util.*

class ChatCreatedEvent(
    private val userId: UUID,
    aggregateId: UUID,
    id: UUID = UUID.randomUUID(),
    occurredOn: Instant = Instant.now()
) : Event(aggregateId, id, occurredOn) {

    fun userId(): UUID = userId

}