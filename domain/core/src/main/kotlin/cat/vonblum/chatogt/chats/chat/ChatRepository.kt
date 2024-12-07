package cat.vonblum.chatogt.chats.chat

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId

interface ChatRepository {

    fun save(chat: Chat)

    fun findAllIdsByUserId(userId: UserId): List<ChatId>

    fun findById(chatId: ChatId): Chat

    fun deleteById(chatId: ChatId)

}