package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import java.time.Instant

class MongoChatCreatedEvent(
    id: String,
    aggregateId: String,
    occurredOn: Instant,
    val userId: String
) : MongoEvent(id, aggregateId, occurredOn)