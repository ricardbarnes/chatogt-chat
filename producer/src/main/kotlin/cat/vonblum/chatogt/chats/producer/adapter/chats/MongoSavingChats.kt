package cat.vonblum.chatogt.chats.producer.adapter.chats

import cat.vonblum.chatogt.chats.chats.Chat
import cat.vonblum.chatogt.chats.chats.SavingChats
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoSavingChats : SavingChats {

    override fun save(chat: Chat) {
        TODO("Not yet implemented")
    }

    override fun save(chats: List<Chat>) {
        TODO("Not yet implemented")
    }

}