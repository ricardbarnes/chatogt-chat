package cat.vonblum.chatogt

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll

class KafkaIntegrationTest {

    companion object {
        private const val KAFKA_HOST = "localhost"
        private const val KAFKA_PORT = 29092 // Port exposed by docker-compose
        private const val BOOTSTRAP_SERVERS = "$KAFKA_HOST:$KAFKA_PORT"

        @BeforeAll
        @JvmStatic
        fun setUp() {
            // Ensure Kafka is up before running tests
            println("Using Kafka broker at $BOOTSTRAP_SERVERS")
        }

        @AfterAll
        @JvmStatic
        fun tearDown() {
            // Any cleanup logic if required
        }
    }

    @Test
    fun `test Kafka producer and consumer`() {
        // Set up producer properties
        val producerProperties = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVERS,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name
        )

        // Set up consumer properties
        val consumerProperties = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVERS,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java.name,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java.name,
            ConsumerConfig.GROUP_ID_CONFIG to "test-group",
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
        )

        // Create a Kafka producer
        val producer = KafkaProducer<String, String>(producerProperties)

        // Produce a message
        val topic = "test-topic"
        val key = "test-key"
        val value = "test-value"
        producer.send(ProducerRecord(topic, key, value)).get()
        producer.close()

        // Create a Kafka consumer
        val consumer = KafkaConsumer<String, String>(consumerProperties)
        consumer.subscribe(listOf(topic))

        // Consume the message
        val records = consumer.poll(java.time.Duration.ofSeconds(10))
        consumer.close()

        // Assert the message was received
        Assertions.assertEquals(1, records.count())
        val record = records.first()
        Assertions.assertEquals(key, record.key())
        Assertions.assertEquals(value, record.value())
    }

}
