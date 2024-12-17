package cat.vonblum.chatogt.chats.chats

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class Chat(
    val id: ChatId,
    val userId: UserId,
    private var _status: ChatStatus = ChatStatus.NORMAL
) : AggregateRoot() {

    companion object {

        fun create(id: ChatId, userId: UserId): Chat =
            Chat(id, userId).also { chat -> chat.record(ChatCreatedEvent(id.value, userId.value)) }

    }

    val status: ChatStatus get() = this._status

    fun mute() = { _status = ChatStatus.MUTED }.also { record(ChatMutedEvent(id.value)) }

    fun unmute() = { _status = ChatStatus.NORMAL }.also { record(ChatUnmutedEvent(id.value)) }

    fun delete() = { _status = ChatStatus.DELETED }.also { record(ChatDeletedEvent(id.value)) }

}