package cat.vonblum.chatogt.chats.chat

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class Chat(
    private val id: ChatId,
    private val userId: UserId,
    private var status: ChatStatus = ChatStatus.NORMAL
) : AggregateRoot() {

    companion object {

        fun create(id: ChatId, userId: UserId): Chat =
            Chat(id, userId).also { chat -> chat.record(ChatCreatedEvent(id.value, userId.value)) }

    }

    fun id(): ChatId = id

    fun userId(): UserId = userId

    fun chatStatus(): ChatStatus = status

    fun mute() = { status = ChatStatus.MUTED }.also { record(ChatMutedEvent(id.value)) }

    fun unmute() = { status = ChatStatus.NORMAL }.also { record(ChatUnmutedEvent(id.value)) }

    fun delete() = { status = ChatStatus.DELETED }.also { record(ChatDeletedEvent(id.value)) }

}