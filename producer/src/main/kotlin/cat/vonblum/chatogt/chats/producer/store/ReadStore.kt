package cat.vonblum.chatogt.chats.producer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import java.util.UUID

interface ReadStore {

    fun findAll(type: Class<out Event>, aggregateId: UUID): List<Event>

}