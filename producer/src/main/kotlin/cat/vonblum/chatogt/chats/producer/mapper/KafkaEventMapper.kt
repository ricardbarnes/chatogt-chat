package cat.vonblum.chatogt.chats.producer.mapper

import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaEventMapper(private val gson: Gson) {

    fun toKafkaDto(obj: Any): String {
        return gson.toJson(obj)
    }

}