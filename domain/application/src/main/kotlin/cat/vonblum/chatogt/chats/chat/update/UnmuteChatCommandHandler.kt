package cat.vonblum.chatogt.chats.chat.update

import cat.vonblum.chatogt.chats.chat.ChatProvider
import cat.vonblum.chatogt.chats.chat.ChatRepository
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class UnmuteChatCommandHandler(
    private val repository: ChatRepository,
    private val provider: ChatProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: UnmuteChatCommand) = repository.findById(ChatId(command.id())).let { chat ->
        chat.unmute()
        provider.send(chat)
        eventBus.publish(chat.pullEvents())
    }

}