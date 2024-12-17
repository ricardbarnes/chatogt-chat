package cat.vonblum.chatogt.chats.messages

import cat.vonblum.chatogt.chats.shared.ChatId

interface FindingMessages {

    fun findById(messageId: MessageId): Message

    fun findAllLatestByChatId(chatId: ChatId, limit: Int): List<Message>

}