package cat.vonblum.chatogt.chats.producer.adapter.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import cat.vonblum.chatogt.chats.users.DeletingUsers
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class MongoDeletingUsers : DeletingUsers {

    override fun deleteById(id: UserId) {
        TODO("Not yet implemented")
    }

}