package cat.vonblum.chatogt.chats.chats.delete

import cat.vonblum.chatogt.chats.chats.ChatProvider
import cat.vonblum.chatogt.chats.chats.ChatRepository
import cat.vonblum.chatogt.chats.shared.ChatId
import cat.vonblum.chatogt.chats.shared.domain.command.CommandHandler
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus

class DeleteChatCommandHandler(
    private val repository: ChatRepository,
    private val provider: ChatProvider,
    private val eventBus: EventBus
) : CommandHandler {

    fun handle(command: DeleteChatCommand) = repository.findById(ChatId(command.id)).let { chat ->
        chat.delete()
        provider.send(chat)
        eventBus.publish(chat.pullEvents())
    }

}