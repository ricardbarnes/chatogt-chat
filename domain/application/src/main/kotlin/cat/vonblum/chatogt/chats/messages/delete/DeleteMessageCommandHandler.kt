package cat.vonblum.chatogt.chats.messages.delete

import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.MessageProvider
import cat.vonblum.chatogt.chats.messages.MessageRepository
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class DeleteMessageCommandHandler(
    private val repository: MessageRepository,
    private val provider: MessageProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: DeleteMessageCommand) = repository.findById(MessageId(command.id)).let { message ->
        message.delete()
        provider.send(message)
        eventBus.publish(message.pullEvents())
    }

}