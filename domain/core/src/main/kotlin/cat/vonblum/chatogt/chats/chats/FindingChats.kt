package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.chats.shared.ChatId

interface FindingChats {

    fun findById(id: ChatId): Chat

}