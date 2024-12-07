package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.chat.Chat
import cat.vonblum.chatogt.chats.chat.ChatRepository
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import org.springframework.stereotype.Component

@Component
class InMemoryChatReadRepository : ChatRepository {

    override fun save(chat: Chat) {
        TODO("Not yet implemented")
    }

    override fun findAllIdsByUserId(userId: UserId): List<ChatId> {
        TODO("Not yet implemented")
    }

    override fun findById(chatId: ChatId): Chat {
        TODO("Not yet implemented")
    }

    override fun deleteById(chatId: ChatId) {
        TODO("Not yet implemented")
    }

}