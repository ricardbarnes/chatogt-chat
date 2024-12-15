package cat.vonblum.chatogt.chats.producer.bus

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus
import org.springframework.stereotype.Component

@Component
class KafkaEventBus : EventBus {

    override fun publish(events: List<Event>) {
        println("Publishing events: $events")
    }

}