package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.producer.repository.ChatRepository
import cat.vonblum.chatogt.chats.producer.store.ReadStore
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingChats(
    private val store: ReadStore,
    private val repository: ChatRepository,
) : FindingChats {

    override fun findById(id: ChatId): Chat {
        TODO("Not yet implemented")
    }

    override fun findAllByUserId(userId: UserId): Set<Chat> {
        println("Finding all chats for user ID ${userId.value}...") // TODO...
        return setOf()
    }

}