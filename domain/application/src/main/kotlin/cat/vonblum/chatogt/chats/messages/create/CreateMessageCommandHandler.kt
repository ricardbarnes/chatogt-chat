package cat.vonblum.chatogt.chats.messages.create

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.MessageContent
import cat.vonblum.chatogt.chats.messages.MessageId
import cat.vonblum.chatogt.chats.messages.MessageProvider
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