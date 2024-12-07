package cat.vonblum.chatogt.chats.shared.domain.event

interface EventBus {

    fun publish(events: List<Event>)

}