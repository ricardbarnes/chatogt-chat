package cat.vonblum.chatogt.chats.shared.domain.event

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import java.time.Instant
import java.util.*

@Suppress("unused")
@UsedBy("events")
abstract class Event(
    val aggregateId: UUID,
    val id: UUID,
    val occurredOn: Instant,
)