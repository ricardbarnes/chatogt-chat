package cat.vonblum.chatogt.chats.producer.config

import cat.vonblum.chatogt.chats.chat.ChatProvider
import cat.vonblum.chatogt.chats.chat.ChatRepository
import cat.vonblum.chatogt.chats.chat.delete.DeleteChatCommandHandler
import cat.vonblum.chatogt.chats.chat.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.chat.find.FindChatIdsQueryHandler
import cat.vonblum.chatogt.chats.chat.update.MuteChatCommandHandler
import cat.vonblum.chatogt.chats.chat.update.UnmuteChatCommandHandler
import cat.vonblum.chatogt.chats.message.MessageProvider
import cat.vonblum.chatogt.chats.message.MessageRepository
import cat.vonblum.chatogt.chats.message.create.CreateMessageCommandHandler
import cat.vonblum.chatogt.chats.message.delete.DeleteMessageCommandHandler
import cat.vonblum.chatogt.chats.message.find.FindMessageIdsQueryHandler
import cat.vonblum.chatogt.chats.message.find.FindMessageQueryHandler
import cat.vonblum.chatogt.chats.message.update.UpdateMessageCommandHandler
import cat.vonblum.chatogt.chats.shared.domain.annotation.HandlerDefinition
import cat.vonblum.chatogt.chats.shared.domain.annotation.HandlerRegistry
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus
import cat.vonblum.chatogt.chats.shared.domain.handler.Handler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringProducerHandlerConfig {

    @Bean
    fun handler(handlers: List<Any>): Handler {
        return Handler(handlers)
    }

    @HandlerRegistry
    @Bean
    fun handlers(
        createChatCommandHandler: CreateChatCommandHandler,
        muteChatCommandHandler: MuteChatCommandHandler,
        unmuteChatCommandHandler: UnmuteChatCommandHandler,
        deleteChatCommandHandler: DeleteChatCommandHandler,
        findChatIdsQueryHandler: FindChatIdsQueryHandler,
        createMessageCommandHandler: CreateMessageCommandHandler,
        deleteMessageCommandHandler: DeleteMessageCommandHandler,
        findMessageIdsQueryHandler: FindMessageIdsQueryHandler,
        findMessageQueryHandler: FindMessageQueryHandler,
        updateMessageCommandHandler: UpdateMessageCommandHandler,
    ): List<Any> {
        return listOf(
            createChatCommandHandler,
            muteChatCommandHandler,
            unmuteChatCommandHandler,
            deleteChatCommandHandler,
            findChatIdsQueryHandler,
            createMessageCommandHandler,
            deleteMessageCommandHandler,
            findMessageIdsQueryHandler,
            findMessageQueryHandler,
            updateMessageCommandHandler,
        )
    }

    @HandlerDefinition
    @Bean
    fun createChatCommandHandler(
        chatProvider: ChatProvider,
        eventBus: EventBus,
    ): CreateChatCommandHandler {
        return CreateChatCommandHandler(
            chatProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun muteChatCommandHandler(
        chatRepository: ChatRepository,
        chatProvider: ChatProvider,
        eventBus: EventBus,
    ): MuteChatCommandHandler {
        return MuteChatCommandHandler(
            chatRepository,
            chatProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun unmuteChatCommandHandler(
        chatRepository: ChatRepository,
        chatProvider: ChatProvider,
        eventBus: EventBus
    ): UnmuteChatCommandHandler {
        return UnmuteChatCommandHandler(
            chatRepository,
            chatProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun cancelChatCommandHandler(
        chatRepository: ChatRepository,
        chatProvider: ChatProvider,
        eventBus: EventBus,
    ): DeleteChatCommandHandler {
        return DeleteChatCommandHandler(
            chatRepository,
            chatProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatQueryHandler(chatRepository: ChatRepository): FindChatIdsQueryHandler {
        return FindChatIdsQueryHandler(chatRepository)
    }

    @HandlerDefinition
    @Bean
    fun createMessageCommandHandler(
        messageProvider: MessageProvider,
        eventBus: EventBus
    ): CreateMessageCommandHandler {
        return CreateMessageCommandHandler(
            messageProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun deleteMessageCommandHandler(
        messageRepository: MessageRepository,
        messageProvider: MessageProvider,
        eventBus: EventBus
    ): DeleteMessageCommandHandler {
        return DeleteMessageCommandHandler(
            messageRepository,
            messageProvider,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findMessageIdsQueryHandler(messageRepository: MessageRepository): FindMessageIdsQueryHandler {
        return FindMessageIdsQueryHandler(messageRepository)
    }

    @HandlerDefinition
    @Bean
    fun findMessageQueryHandler(messageRepository: MessageRepository): FindMessageQueryHandler {
        return FindMessageQueryHandler(messageRepository)
    }

    @HandlerDefinition
    @Bean
    fun updateMessageCommandHandler(
        messageRepository: MessageRepository,
        messageProvider: MessageProvider,
        eventBus: EventBus
    ): UpdateMessageCommandHandler {
        return UpdateMessageCommandHandler(
            messageRepository,
            messageProvider,
            eventBus
        )
    }

}