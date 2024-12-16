package cat.vonblum.chatogt.chats.consumer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.domain.event.EventWriteStore
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class MongoWriteStore(
    private val mongoTemplate: MongoTemplate
) : EventWriteStore {

    override fun save(event: Event) {
        mongoTemplate.save(event)
    }

}