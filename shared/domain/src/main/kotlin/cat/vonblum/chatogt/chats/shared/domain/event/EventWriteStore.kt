package cat.vonblum.chatogt.chats.shared.domain.event

interface EventWriteStore {

    fun save(event: Event)

}