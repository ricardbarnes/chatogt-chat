package cat.vonblum.chatogt.chats.producer.config

import cat.vonblum.chatogt.chats.chats.FindingChats
import cat.vonblum.chatogt.chats.chats.delete.DeleteChatCommandHandler
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.chats.find.FindChatQueryHandler
import cat.vonblum.chatogt.chats.chats.update.UpdateChatCommandHandler
import cat.vonblum.chatogt.chats.messages.FindingMessages
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import cat.vonblum.chatogt.chats.messages.create.CreateMessageCommandHandler
import cat.vonblum.chatogt.chats.messages.delete.DeleteMessageCommandHandler
import cat.vonblum.chatogt.chats.messages.find.FindMessageIdsQueryHandler
import cat.vonblum.chatogt.chats.messages.find.FindMessageQueryHandler
import cat.vonblum.chatogt.chats.messages.update.UpdateMessageCommandHandler
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
        updateChatCommandHandler: UpdateChatCommandHandler,
        deleteChatCommandHandler: DeleteChatCommandHandler,
        findChatQueryHandler: FindChatQueryHandler,
        createMessageCommandHandler: CreateMessageCommandHandler,
        deleteMessageCommandHandler: DeleteMessageCommandHandler,
        findMessageIdsQueryHandler: FindMessageIdsQueryHandler,
        findMessageQueryHandler: FindMessageQueryHandler,
        updateMessageCommandHandler: UpdateMessageCommandHandler,
    ): List<Any> {
        return listOf(
            createChatCommandHandler,
            updateChatCommandHandler,
            deleteChatCommandHandler,
            findChatQueryHandler,
            createMessageCommandHandler,
            deleteMessageCommandHandler,
            findMessageIdsQueryHandler,
            findMessageQueryHandler,
            updateMessageCommandHandler,
        )
    }

    @HandlerDefinition
    @Bean
    fun createChatCommandHandler(eventBus: EventBus): CreateChatCommandHandler {
        return CreateChatCommandHandler(eventBus)
    }

    @HandlerDefinition
    @Bean
    fun muteChatCommandHandler(
        findingChats: FindingChats,
        eventBus: EventBus,
    ): UpdateChatCommandHandler {
        return UpdateChatCommandHandler(
            findingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun cancelChatCommandHandler(
        findingChats: FindingChats,
        eventBus: EventBus,
    ): DeleteChatCommandHandler {
        return DeleteChatCommandHandler(
            findingChats,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findChatQueryHandler(findingChats: FindingChats): FindChatQueryHandler {
        return FindChatQueryHandler(findingChats)
    }

    @HandlerDefinition
    @Bean
    fun createMessageCommandHandler(
        eventBus: EventBus,
        reportingMessages: ReportingMessages
    ): CreateMessageCommandHandler {
        return CreateMessageCommandHandler(
            eventBus,
            reportingMessages
        )
    }

    @HandlerDefinition
    @Bean
    fun deleteMessageCommandHandler(
        findingMessages: FindingMessages,
        eventBus: EventBus
    ): DeleteMessageCommandHandler {
        return DeleteMessageCommandHandler(
            findingMessages,
            eventBus
        )
    }

    @HandlerDefinition
    @Bean
    fun findMessageIdsQueryHandler(findingMessages: FindingMessages): FindMessageIdsQueryHandler {
        return FindMessageIdsQueryHandler(findingMessages)
    }

    @HandlerDefinition
    @Bean
    fun findMessageQueryHandler(findingMessages: FindingMessages): FindMessageQueryHandler {
        return FindMessageQueryHandler(findingMessages)
    }

    @HandlerDefinition
    @Bean
    fun updateMessageCommandHandler(
        findingMessages: FindingMessages,
        eventBus: EventBus
    ): UpdateMessageCommandHandler {
        return UpdateMessageCommandHandler(
            findingMessages,
            eventBus
        )
    }

}