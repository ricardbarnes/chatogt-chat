package cat.vonblum.chatogt.chats.message

import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.aggregate.AggregateRoot

class Message(
    private val id: MessageId,
    private val chatId: ChatId,
    private var content: MessageContent,
    private var status: MessageStatus = MessageStatus.NORMAL,
) : AggregateRoot() {

    companion object {

        fun create(id: MessageId, chatId: ChatId, content: MessageContent): Message =
            Message(id, chatId, content).also { message -> message.record(MessageCreatedEvent(message.id.value)) }

    }

    fun id(): MessageId = id

    fun chatId(): ChatId = chatId

    fun content(): MessageContent = content

    fun status(): MessageStatus = status

    fun star() = { status = MessageStatus.STARRED }.also { record(MessageStarredEvent(id.value)) }

    fun delete() = { status = MessageStatus.DELETED }.also { record(MessageDeletedEvent(id.value)) }

    fun update(content: MessageContent) = this.apply { this.content = content }

}