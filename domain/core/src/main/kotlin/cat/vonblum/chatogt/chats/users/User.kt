package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class User(val id: UserId) : AggregateRoot() {

    companion object {

        fun create(id: UserId): User = User(id).also { user: User -> user.record(UserCreatedEvent(id.value)) }

    }

}