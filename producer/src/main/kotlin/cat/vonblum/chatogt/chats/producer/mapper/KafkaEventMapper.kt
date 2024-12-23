package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaEventMapper(private val gson: Gson) {

    fun toKafkaDto(event: Event): String {
        return gson.toJson(event)
    }

}