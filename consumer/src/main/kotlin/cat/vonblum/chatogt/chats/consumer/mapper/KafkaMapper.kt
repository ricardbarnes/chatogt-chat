package cat.vonblum.chatogt.chats.consumer.mapper

import cat.vonblum.chatogt.chats.shared.domain.event.Event
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaMapper(private val gson: Gson) {

    fun toDomain(json: String): Event {
        return gson.fromJson(json, Event::class.java)
    }

}