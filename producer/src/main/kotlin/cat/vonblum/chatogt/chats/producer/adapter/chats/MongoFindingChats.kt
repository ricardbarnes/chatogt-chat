package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingChats : FindingChats {

    override fun findById(id: ChatId): Chat {
        TODO("Not yet implemented")
    }

    override fun findAllByUserId(userId: UserId): List<ChatId> {
        TODO("Not yet implemented")
    }

}