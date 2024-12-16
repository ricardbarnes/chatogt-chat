package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "chat_created_event")
@Suppress("unused")
@UsedBy("@Document")
class MongoChatCreatedEvent(
    id: String,
    aggregateId: String,
    occurredOn: Instant,
    val userId: String
) : MongoEvent(id, aggregateId, occurredOn)