package cat.vonblum.chatogt.chats.producer.adapter.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import cat.vonblum.chatogt.chats.users.FindingUsers
import cat.vonblum.chatogt.chats.users.User
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoFindingUsers : FindingUsers {

    override fun findById(id: UserId): User {
        println("PEPE! Finding user!")
        return User(id, mutableListOf())
    }

}