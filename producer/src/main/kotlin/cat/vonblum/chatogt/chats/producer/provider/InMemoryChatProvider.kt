package cat.vonblum.chatogt.chats.producer.provider

import cat.vonblum.chatogt.chats.chat.Chat
import cat.vonblum.chatogt.chats.chat.ChatProvider
import org.springframework.stereotype.Component

@Component
class InMemoryChatProvider : ChatProvider {

    override fun send(chat: Chat) {
        println("sending chat $chat to FBI")
    }

}