package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class User(
    val id: UserId,
    val contactIds: MutableSet<UserId>,
) : AggregateRoot() {

    companion object {

        fun create(id: UserId, ids: MutableSet<UserId>): User =
            User(id, ids).also { user: User ->
                user.record(UserCreatedEvent(
                    id.value,
                    ids.map { it.value }
                ))
            }

    }

    fun addContact(userId: UserId) = contactIds.add(userId)

    fun removeContact(userId: UserId) = contactIds.remove(userId)

}