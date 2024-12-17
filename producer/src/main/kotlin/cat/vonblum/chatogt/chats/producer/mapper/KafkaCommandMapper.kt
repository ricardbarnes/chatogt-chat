package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaCommandMapper(private val gson: Gson) {

    fun toDomain(obj: Any): CreateChatCommand {
        return gson.fromJson(obj.toString(), CreateChatCommand::class.java)
    }

}