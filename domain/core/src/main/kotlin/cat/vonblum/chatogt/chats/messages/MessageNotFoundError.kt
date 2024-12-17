package cat.vonblum.chatogt.chats.messages

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.error.Error

class MessageNotFoundError(override val message: String) : Error(message) {

    companion object {

        fun becauseOf(chatId: ChatId): MessageNotFoundError = MessageNotFoundError("Message ${chatId.value} not found.")

    }

}