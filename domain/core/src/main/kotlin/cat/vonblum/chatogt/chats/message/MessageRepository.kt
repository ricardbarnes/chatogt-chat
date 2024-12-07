package cat.vonblum.chatogt.chats.message

import cat.vonblum.chatogt.chats.shared.ChatId

interface MessageRepository {

    fun findAllIdsByChatId(chatId: ChatId): List<MessageId>

    fun findById(messageId: MessageId): Message

}