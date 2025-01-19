package cat.vonblum.chatogt.chats.producer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.domain.valueobject.Id

interface ReadStore {

    fun findAll(type: Class<out Event>, aggregateId: Id): List<Event>

}