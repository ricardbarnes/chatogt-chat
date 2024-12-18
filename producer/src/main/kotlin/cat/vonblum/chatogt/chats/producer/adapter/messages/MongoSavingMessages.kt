package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.SavingMessages
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoSavingMessages : SavingMessages {

    override fun save(message: Message) {
        TODO("Not yet implemented")
    }

}