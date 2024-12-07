package cat.vonblum.chatogt.chats.consumer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.domain.event.EventWriteStore
import org.springframework.stereotype.Component

@Component
class InMemoryWriteStore : EventWriteStore {

    override fun save(event: Event) {
        println("Saved event: $event")
    }

}