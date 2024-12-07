package cat.vonblum.chatogt.chats.shared.domain.query

interface QueryBus {

    fun ask(query: Query): Response?

}