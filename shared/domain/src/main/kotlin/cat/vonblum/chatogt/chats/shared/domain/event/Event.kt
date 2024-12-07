package cat.vonblum.chatogt.chats.shared.domain.event

import java.time.Instant
import java.util.*

interface Event {

    val aggregateId: UUID

    var id: UUID

    val occurredOn: Instant

}