package cat.vonblum.chatogt.chats.messages

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class Message(
    val id: MessageId,
    val chatId: ChatId,
    private var _content: MessageContent,
    private var _status: MessageStatus = MessageStatus.NORMAL,
) : AggregateRoot() {

    companion object {

        fun create(id: MessageId, chatId: ChatId, content: MessageContent): Message =
            Message(id, chatId, content).also { message -> message.record(MessageCreatedEvent(message.id.value)) }

    }

    val content get() = _content

    val status get() = _status

    fun star() = { _status = MessageStatus.STARRED }.also { record(MessageStarredEvent(id.value)) }

    fun delete() = { _status = MessageStatus.DELETED }.also { record(MessageDeletedEvent(id.value)) }

    fun update(content: MessageContent) = this.apply { this._content = content }

}