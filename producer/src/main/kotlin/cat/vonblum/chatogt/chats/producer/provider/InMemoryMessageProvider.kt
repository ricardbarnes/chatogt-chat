package cat.vonblum.chatogt.chats.producer.provider

import cat.vonblum.chatogt.chats.message.Message
import cat.vonblum.chatogt.chats.message.MessageProvider
import org.springframework.stereotype.Component

@Component
class InMemoryMessageProvider : MessageProvider {

    override fun send(message: Message) {
        TODO("Not yet implemented")
    }

}