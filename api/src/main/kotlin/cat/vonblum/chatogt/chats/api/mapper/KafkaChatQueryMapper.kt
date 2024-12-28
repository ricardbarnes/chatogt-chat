package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.users.find.FindUserResponse
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaChatQueryMapper(private val gson: Gson) {

    fun toDto(query: FindChatQuery): String = gson.toJson(query)

    fun toDomain(response: String): Response? {
        // TODO
        return gson.fromJson(response, FindUserResponse::class.java)
    }

}