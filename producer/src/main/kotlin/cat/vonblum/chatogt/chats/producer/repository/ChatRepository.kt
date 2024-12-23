package cat.vonblum.chatogt.chats.producer.repository

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId

interface ChatRepository {

    fun findAllIdsByUserId(userId: UserId): List<ChatId>

}