package cat.vonblum.chatogt.chats.messages.update

import cat.vonblum.chatogt.chats.messages.MessageContent
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.MessageProvider
import cat.vonblum.chatogt.chats.messages.MessageRepository
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class UpdateMessageCommandHandler(
    private val repository: MessageRepository,
    private val provider: MessageProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UpdateMessageCommand) = repository.findById(MessageId(command.id)).let { message ->
        message.update(MessageContent(command.content))
        provider.send(message)
        eventBus.publish(message.pullEvents())
    }

}