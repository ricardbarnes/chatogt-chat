package cat.vonblum.chatogt.chats.shared.domain.event

interface EventReadStore {

    fun findAll(type: Class<out Event>): List<Event>

}