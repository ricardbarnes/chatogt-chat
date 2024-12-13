package cat.vonblum.chatogt.chats.producer.config

import cat.vonblum.chatogt.chats.producer.deserializer.KafkaCreateChatCommandDeserializer
import cat.vonblum.chatogt.chats.shared.infrastructure.command.KafkaCreateChatCommand
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.UUIDDeserializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class KafkaProducerConfig {

    @Bean
    fun kafkaCommandTopic(@Value("\${kafka.topics.commands}") kafkaCommandTopic: String): String {
        return kafkaCommandTopic
    }

    @Bean
    fun kafkaConsumerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, String> {
        return mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to UUIDDeserializer::class.java.name,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to KafkaCreateChatCommandDeserializer::class.java.name,
            ConsumerConfig.GROUP_ID_CONFIG to "test-group",
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
        )
    }

    @Bean
    fun kafkaProducer(
        @Qualifier("kafkaConsumerProperties") properties: Map<String, String>
    ): KafkaConsumer<UUID, KafkaCreateChatCommand> {
        return KafkaConsumer<UUID, KafkaCreateChatCommand>(properties)
    }

}