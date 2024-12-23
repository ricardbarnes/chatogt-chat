package cat.vonblum.chatogt.chats.consumer.mapper

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoChatCreatedEvent
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoEvent
import org.springframework.stereotype.Component

@Component
class MongoMapper {

    fun map(event: Event): MongoEvent {
        return when (event) {
            is ChatCreatedEvent -> map(event)
            else -> {
                throw RuntimeException() // TODO
            }
        }
    }

    private fun map(event: ChatCreatedEvent): MongoChatCreatedEvent {
        return MongoChatCreatedEvent(
            event.id.toString(),
            event.aggregateId.toString(),
            event.occurredOn,
            event.userId.toString()
        )
    }

}