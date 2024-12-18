package cat.vonblum.chatogt.chats.producer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.infrastructure.store.ReadStore

class MongoReadStore : ReadStore {

    override fun findAll(type: Class<out Event>): List<Event> {
        TODO("Not yet implemented")
    }

}