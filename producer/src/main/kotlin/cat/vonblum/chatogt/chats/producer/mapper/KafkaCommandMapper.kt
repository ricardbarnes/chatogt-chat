package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun toDomain(json: String): CreateChatCommand {
        return gson.fromJson(json, CreateChatCommand::class.java)
    }

}