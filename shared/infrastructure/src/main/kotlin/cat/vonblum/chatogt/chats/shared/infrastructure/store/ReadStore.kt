package cat.vonblum.chatogt.chats.shared.infrastructure.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event

interface ReadStore {

    fun findAll(type: Class<out Event>): List<Event>

}