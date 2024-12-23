package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoChatCreatedEvent
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoEvent
import org.springframework.stereotype.Component
import java.util.*

@Component
class MongoEventMapper {

    fun map(types: List<MongoEvent>): List<Event> {
        return types.map { map(it) }
    }

    private fun map(mongoEvent: MongoEvent): Event {
        return when (mongoEvent) { // TODO...
            is MongoChatCreatedEvent -> aChatCreatedEvent(mongoEvent)
            else -> throw IllegalArgumentException("unknown event type: $mongoEvent")
        }
    }

    private fun aChatCreatedEvent(mongoEvent: MongoChatCreatedEvent): Event {
        return ChatCreatedEvent(
            UUID.fromString(mongoEvent.userId),
            UUID.fromString(mongoEvent.aggregateId),
            UUID.fromString(mongoEvent.id),
            mongoEvent.occurredOn
        )
    }

}