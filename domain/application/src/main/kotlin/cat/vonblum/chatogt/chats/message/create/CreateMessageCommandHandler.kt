package cat.vonblum.chatogt.chats.message.create

import cat.vonblum.chatogt.chats.message.Message
import cat.vonblum.chatogt.chats.message.MessageContent
import cat.vonblum.chatogt.chats.message.MessageId
import cat.vonblum.chatogt.chats.message.MessageProvider
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class CreateMessageCommandHandler(
    private val provider: MessageProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: CreateMessageCommand) = Message.create(
        MessageId(command.id),
        ChatId(command.chatId),
        MessageContent(command.content)
    ).let { message ->
        provider.send(message)
        eventBus.publish(message.pullEvents())
    }

}