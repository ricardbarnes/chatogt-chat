package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.api.mapper.KafkaChatCommandMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaMessageCommandMapper
import cat.vonblum.chatogt.chats.api.mapper.KafkaUserCommandMapper
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.command.CommandBus
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DriverAdapter
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.UUID

@DriverAdapter
@Component
class KafkaCommandBus(
    private val chatMapper: KafkaChatCommandMapper,
    private val messageMapper: KafkaMessageCommandMapper,
    private val userMapper: KafkaUserCommandMapper,
    private val producer: KafkaProducer<UUID, String>,
    @Value("\${kafka.topics.commands}") private val topic: String
) : CommandBus {

    override fun dispatch(command: Command) {
        when (command) {
            is CreateChatCommand -> dispatchCreateChatCommand(command)
        }
    }

    private fun dispatchCreateChatCommand(command: CreateChatCommand) {
        producer.send(
            ProducerRecord(
                topic,
                command.id,
                chatMapper.toDto(command)
            )
        ).get()
    }

}