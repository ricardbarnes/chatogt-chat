package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toDomain(obj: Any): CreateChatCommand {
        return gson.fromJson(obj.toString(), CreateChatCommand::class.java)
    }

}