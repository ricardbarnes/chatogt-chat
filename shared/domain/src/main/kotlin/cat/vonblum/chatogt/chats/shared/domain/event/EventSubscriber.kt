package cat.vonblum.chatogt.chats.shared.domain.event

interface EventSubscriber {

    fun subscribedTo(): List<Any>

}