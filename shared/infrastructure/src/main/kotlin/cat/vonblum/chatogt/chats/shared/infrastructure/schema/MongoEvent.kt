package cat.vonblum.chatogt.chats.shared.infrastructure.schema

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy
import org.springframework.data.annotation.Id
import java.time.Instant

@Suppress("unused")
@UsedBy("org.springframework.data")
abstract class MongoEvent(
    @Id val id: String,
    val aggregateId: String,
    val occurredOn: Instant,
)