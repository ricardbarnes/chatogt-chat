package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaChatCommandMapper(private val gson: Gson) {

    fun toDto(command: CreateChatCommand): String = gson.toJson(command)

}