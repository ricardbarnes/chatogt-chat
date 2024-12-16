package cat.vonblum.chatogt.chats.shared.domain.event

import java.time.Instant
import java.util.*

abstract class Event(
    val aggregateId: UUID,
    val id: UUID,
    val occurredOn: Instant,
)