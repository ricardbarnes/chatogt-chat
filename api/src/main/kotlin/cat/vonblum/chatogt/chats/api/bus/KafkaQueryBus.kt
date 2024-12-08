package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import org.springframework.stereotype.Component

@Component
class KafkaQueryBus : QueryBus {

    override fun ask(query: Query): Response? {
        println("Asked for $query")
        return null
    }

}