package cat.vonblum.chatogt.chats.producer.provider

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.ChatProvider
import org.springframework.stereotype.Component

@Component
class InMemoryChatProvider : ChatProvider {

    override fun send(chat: Chat) {
        println("sending chat $chat to FBI")
    }

}