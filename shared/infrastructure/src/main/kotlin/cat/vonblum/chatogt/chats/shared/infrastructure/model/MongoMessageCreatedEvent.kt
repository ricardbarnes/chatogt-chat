package cat.vonblum.chatogt.chats.shared.infrastructure.model

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "message_created_event")
@Suppress("unused")
@UsedBy("@Document")
class MongoMessageCreatedEvent(
    id: String,
    aggregateId: String,
    val chatId: String,
    val content: String,
    occurredOn: Instant,
) : MongoEvent(id, aggregateId, occurredOn)