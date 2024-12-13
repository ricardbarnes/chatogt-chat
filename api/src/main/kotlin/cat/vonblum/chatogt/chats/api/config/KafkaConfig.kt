package cat.vonblum.chatogt.chats.api.config

import cat.vonblum.chatogt.chats.api.command.KafkaCreateChatCommand
import cat.vonblum.chatogt.chats.api.serializer.KafkaCreateChatCommandSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.UUIDSerializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class KafkaConfig {

    @Bean
    fun kafkaCommandTopic(@Value("\${kafka.topics.commands}") kafkaCommandTopic: String): String {
        return kafkaCommandTopic
    }

    @Bean
    fun kafkaProducerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, String> {
        return mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to UUIDSerializer::class.java.name,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to KafkaCreateChatCommandSerializer::class.java.name
        )
    }

    @Bean
    fun kafkaProducer(
        @Qualifier("kafkaProducerProperties") properties: Map<String, String>
    ): KafkaProducer<UUID, KafkaCreateChatCommand> {
        return KafkaProducer<UUID, KafkaCreateChatCommand>(properties)
    }

}