package cat.vonblum.chatogt.chats.shared.domain.query

import cat.vonblum.chatogt.chats.shared.domain.annotation.UsedBy

@Suppress("unused")
@UsedBy("query bus implementations")
interface QueryBus {

    fun ask(query: Query): Response?

}