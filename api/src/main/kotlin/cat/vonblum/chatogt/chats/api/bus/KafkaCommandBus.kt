package cat.vonblum.chatogt.chats.api.bus

import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.command.CommandBus
import org.springframework.stereotype.Component

@Component
class KafkaCommandBus : CommandBus {

    override fun dispatch(command: Command) {
        println("Dispatched command: $command")
    }

}