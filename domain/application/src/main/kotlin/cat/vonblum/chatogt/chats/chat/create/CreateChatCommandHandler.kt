package cat.vonblum.chatogt.chats.chat.create

import cat.vonblum.chatogt.chats.chat.Chat
import cat.vonblum.chatogt.chats.chat.ChatProvider
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class CreateChatCommandHandler(
    private val provider: ChatProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: CreateChatCommand) = Chat.create(
        ChatId(command.id()),
        UserId(command.userId()),
    ).let { chat ->
        provider.send(chat)
        eventBus.publish(chat.pullEvents())
    }

}