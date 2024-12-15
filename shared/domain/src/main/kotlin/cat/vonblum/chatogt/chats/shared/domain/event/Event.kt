package cat.vonblum.chatogt.chats.shared.domain.event

import java.time.Instant
import java.util.*

abstract class Event(
    private val aggregateId: UUID,
    private val id: UUID,
    private val occurredOn: Instant,
) {

    fun aggregateId(): UUID = aggregateId

    fun id(): UUID = id

    fun occurredOn(): Instant = occurredOn

}