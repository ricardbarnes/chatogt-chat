package cat.vonblum.chatogt.chats.shared.infrastructure.config

import com.google.gson.Gson
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.common.serialization.UUIDDeserializer
import org.apache.kafka.common.serialization.UUIDSerializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class SpringSharedKafkaConfig {

    @Bean
    fun gson(): Gson {
        return Gson()
    }

    @Bean
    fun kafkaProducerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, String> {
        return mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to UUIDSerializer::class.java.name,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name
        )
    }

    @Bean
    fun kafkaProducer(
        @Qualifier("kafkaProducerProperties") properties: Map<String, String>
    ): KafkaProducer<UUID, String> {
        return KafkaProducer<UUID, String>(properties)
    }

    @Bean
    fun kafkaConsumerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, String> {
        return mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to UUIDDeserializer::class.java.name,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java.name
        )
    }

    @Bean
    fun kafkaConsumer(
        @Qualifier("kafkaConsumerProperties") properties: Map<String, String>
    ): KafkaConsumer<UUID, String> {
        return KafkaConsumer<UUID, String>(properties)
    }

}