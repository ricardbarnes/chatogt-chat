package cat.vonblum.chatogt.chats.chat

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.error.Error

class ChatNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): ChatNotFoundError = ChatNotFoundError("Chat ${chatId.value} not found.")

    }

}