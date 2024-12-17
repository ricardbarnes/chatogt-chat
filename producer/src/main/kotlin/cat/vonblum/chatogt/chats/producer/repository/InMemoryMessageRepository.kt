package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.MessageRepository
import cat.vonblum.chatogt.chats.shared.ChatId
import org.springframework.stereotype.Component

@Component
class InMemoryMessageRepository : MessageRepository {

    override fun findAllIdsByChatId(chatId: ChatId): List<MessageId> {
        TODO("Not yet implemented")
    }

    override fun findById(messageId: MessageId): Message {
        TODO("Not yet implemented")
    }

}