package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaChatQueryMapper(private val gson: Gson) {

    fun toDto(query: FindChatQuery): String = gson.toJson(query)

}