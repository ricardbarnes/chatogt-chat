package cat.vonblum.chatogt.chats.consumer.store

import cat.vonblum.chatogt.chats.shared.domain.event.Event

interface WriteStore {

    fun save(event: Event)

}