package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatsByUserIdQuery
import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toFindUserQuery(json: String): FindUserQuery {
        return gson.fromJson(json, FindUserQuery::class.java)
    }

    fun toFindChatsByUserId(json: String): FindChatsByUserIdQuery {
        return gson.fromJson(json, FindChatsByUserIdQuery::class.java)
    }

}