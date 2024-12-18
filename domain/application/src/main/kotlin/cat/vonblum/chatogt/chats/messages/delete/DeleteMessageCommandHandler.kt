package cat.vonblum.chatogt.chats.messages.delete

import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class DeleteMessageCommandHandler(
    private val finding: FindingMessages,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: DeleteMessageCommand) = finding.findById(MessageId(command.id)).let { message ->
        message.delete()
        eventBus.publish(message.pullEvents())
    }

}