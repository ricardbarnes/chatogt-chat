package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId

interface FindingChats {

    fun findById(id: ChatId): Chat

    fun findAllByUserId(userId: UserId): List<ChatId>

}