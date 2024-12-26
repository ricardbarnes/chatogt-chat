package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class User(
    val id: UserId,
    val chatIds: MutableList<ChatId>,
) : AggregateRoot() {

    companion object {

        fun create(
            id: UserId,
            chatIds: MutableList<ChatId> = mutableListOf(),
            blockedUserIds: MutableList<UserId> = mutableListOf()
        ): User =
            User(id, chatIds).also { user: User ->
                user.record(
                    UserCreatedEvent(
                        chatIds.stream().map { it.value }.toList(),
                        blockedUserIds.stream().map { it.value }.toList(),
                        id.value
                    )
                )
            }

    }

    fun addChatId(chatId: ChatId) = chatIds.add(chatId)

    fun removeChatId(chatId: ChatId) = chatIds.remove(chatId)

}