package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaChatQueryMapper(private val gson: Gson) {

    fun toDomain(response: String?): Response? {
        return gson.fromJson(response, FindChatIdsByUserIdResponse::class.java)
    }

}