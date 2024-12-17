package cat.vonblum.chatogt.chats.producer.provider

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.MessageProvider
import org.springframework.stereotype.Component

@Component
class InMemoryMessageProvider : MessageProvider {

    override fun send(message: Message) {
        TODO("Not yet implemented")
    }

}