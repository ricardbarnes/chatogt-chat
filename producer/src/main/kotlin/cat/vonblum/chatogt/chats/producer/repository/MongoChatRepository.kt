package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.ChatNotFoundError
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
internal class MongoChatRepository(
    private val template: MongoTemplate
) : ChatRepository {

    override fun findAllIdsByUserId(userId: UserId): List<ChatId> {
        val query = Query().addCriteria(Criteria.where("participantIds").`in`(userId.value.toString()))
        query.fields().include("aggregateId")
        val mongoChatIds = template.find(
            query,
            MongoAggregateIdProjection::class.java,
            template.getCollectionName(MongoChatCreatedEvent::class.java)
        )
        return mongoChatIds.map { ChatId(UUID.fromString(it.aggregateId)) }
    }

    override fun findById(id: ChatId): Chat {
        val query = Query().addCriteria(Criteria.where("aggregateId").`is`(id.value.toString()))

        // Find the document using MongoTemplate
        val mongoChatCreatedEvent = template.findOne(
            query,
            MongoChatCreatedEvent::class.java,
            template.getCollectionName(MongoChatCreatedEvent::class.java)
        )

        // Handle the case where no document is found
        return mongoChatCreatedEvent?.let { it ->
            Chat(
                ChatId(UUID.fromString(it.aggregateId)),
                it.participantIds.map { UserId(UUID.fromString(it)) }.toMutableSet(),
            )
        } ?: throw ChatNotFoundError.becauseOf(id)
    }

}