package cat.vonblum.chatogt.chats.producer.store

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import cat.vonblum.chatogt.chats.producer.mapper.MongoEventMapper
import cat.vonblum.chatogt.chats.shared.domain.event.Event
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoEvent
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.UUID

@Component
internal class MongoReadStore(
    private val template: MongoTemplate,
    private val mapper: MongoEventMapper,
) : ReadStore {

    override fun findAll(type: Class<out Event>, aggregateId: UUID): List<Event> {
        val query = Query()
        query.addCriteria(Criteria.where("aggregateId").`is`(aggregateId))
        val mongoType = getMongoType(type)
        return mapper.map(template.find(query, mongoType))
    }

    private fun getMongoType(type: Class<out Event>): Class<out MongoEvent> {
        return when (type) { // TODO
            ChatCreatedEvent::class.java -> MongoEvent::class.java
            else -> throw IllegalArgumentException("type must be a chat created event")
        }
    }

}