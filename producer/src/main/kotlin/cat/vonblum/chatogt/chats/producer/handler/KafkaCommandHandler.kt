package cat.vonblum.chatogt.chats.producer.handler

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommandHandler
import cat.vonblum.chatogt.chats.producer.mapper.KafkaCommandMapper
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import cat.vonblum.chatogt.chats.users.create.CreateUserCommand
import cat.vonblum.chatogt.chats.users.create.CreateUserCommandHandler
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.*

@DriverAdapter
@Component
class KafkaCommandHandler(
    private val mapper: KafkaCommandMapper,
    private val createUserCommandHandler: CreateUserCommandHandler,
    private val createChatCommandHandler: CreateChatCommandHandler
) {

    @KafkaListener(topics = ["\${kafka.topics.commands}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val type = record.headers().lastHeader("type")?.value()?.let { String(it) }

        when (type) {
            CreateUserCommand::class.simpleName -> {
                val command = mapper.toDomain(record.value(), CreateUserCommand::class.java)
                createUserCommandHandler.handle(command)
            }

            CreateChatCommand::class.simpleName -> {
                val command = mapper.toDomain(record.value(), CreateChatCommand::class.java)
                createChatCommandHandler.handle(command)
            }

            else -> {
                throw IllegalArgumentException("Unknown command type: $type")
            }
        }
    }

}
