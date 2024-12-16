package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import org.springframework.data.annotation.Id
import java.time.Instant

abstract class MongoEvent(
    @Id val id: String,
    val aggregateId: String,
    val occurredOn: Instant,
)