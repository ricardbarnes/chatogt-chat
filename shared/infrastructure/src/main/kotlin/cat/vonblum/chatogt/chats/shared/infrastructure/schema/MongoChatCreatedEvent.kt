package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "chat_created_event")
class MongoChatCreatedEvent(
    id: String,
    aggregateId: String,
    occurredOn: Instant,
    val userId: String
) : MongoEvent(id, aggregateId, occurredOn)