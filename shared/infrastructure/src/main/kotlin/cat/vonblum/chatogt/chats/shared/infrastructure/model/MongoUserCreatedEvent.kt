package cat.vonblum.chatogt.chats.shared.infrastructure.model

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "user_created_event")
@Suppress("unused")
@UsedBy("@Document")
class MongoUserCreatedEvent(
    id: String,
    aggregateId: String,
    occurredOn: Instant,
) : MongoEvent(id, aggregateId, occurredOn)