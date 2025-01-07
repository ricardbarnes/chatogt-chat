package cat.vonblum.chatogt.chats.consumer.mapper

import cat.vonblum.chatogt.chats.chats.ChatCreatedEvent
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaMapper(private val gson: Gson) {

    fun toDomain(json: String): ChatCreatedEvent {
        return gson.fromJson(json, ChatCreatedEvent::class.java)
    }

}