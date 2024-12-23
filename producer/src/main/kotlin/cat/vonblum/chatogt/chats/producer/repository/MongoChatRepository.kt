package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.producer.model.MongoAggregateIdProjection
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.infrastructure.model.MongoChatCreatedEvent
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.*

@Component
class MongoChatRepository(
    private val template: MongoTemplate
) : ChatRepository {

    override fun findAllIdsByUserId(userId: UserId): List<ChatId> {
        val query = Query().addCriteria(Criteria.where("userId").`is`(userId.value.toString()))
        query.fields().include("aggregateId")
        val mongoChatIds = template.find(
            query,
            MongoAggregateIdProjection::class.java,
            template.getCollectionName(MongoChatCreatedEvent::class.java)
        )
        return mongoChatIds.map { ChatId(UUID.fromString(it.aggregateId)) }
    }

}