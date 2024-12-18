package cat.vonblum.chatogt.chats.producer.adapter.users

import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import cat.vonblum.chatogt.chats.users.SavingUsers
import cat.vonblum.chatogt.chats.users.User
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoSavingUsers : SavingUsers {

    override fun save(user: User) {
        TODO("Not yet implemented")
    }

}