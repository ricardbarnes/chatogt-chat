package cat.vonblum.chatogt.chats.consumer.mapper

import cat.vonblum.chatogt.chats.chat.ChatCreatedEvent
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaMapper(private val gson: Gson) {

    fun toDomain(obj: Any): ChatCreatedEvent {
        return gson.fromJson(obj.toString(), ChatCreatedEvent::class.java)
    }

}