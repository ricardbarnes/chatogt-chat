package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
abstract class MongoEvent(
    @Id val id: String,
    val aggregateId: String,
    val occurredOn: Instant,
)