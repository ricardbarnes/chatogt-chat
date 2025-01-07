package cat.vonblum.chatogt.chats.consumer.handler

import cat.vonblum.chatogt.chats.consumer.mapper.KafkaMapper
import cat.vonblum.chatogt.chats.consumer.store.WriteStore
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class KafkaEventHandler(
    private val mapper: KafkaMapper,
    private val store: WriteStore
) {

    @KafkaListener(topics = ["\${kafka.topics.events}"])
    fun handle(record: ConsumerRecord<UUID, String>) {
        val headerKey = "type"
        val headerValue = record.headers()
            .lastHeader(headerKey)
            ?.value()
            ?.toString(Charsets.UTF_8)

        store.save(mapper.toDomain(record.value()))
    }

}