package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.users.find.FindUserIdByNameResponse
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaUserQueryMapper(private val gson: Gson) {

    fun toFindUserIdByNameQuery(response: String?): Response? {
        return gson.fromJson(response, FindUserIdByNameResponse::class.java)
    }

    fun toDto(query: Query): String? {
        return gson.toJson(query)
    }

}