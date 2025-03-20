package cat.vonblum.chatogt.chats.shared.infrastructure.io.model

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "user_created_event")
@Suppress("unused")
@UsedBy("@Document")
class MongoUserCreatedEvent(
    id: String,
    aggregateId: String,
    val name: String,
    val password: String,
    occurredOn: Instant,
) : MongoEvent(id, aggregateId, occurredOn)