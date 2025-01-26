package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toFindChatsByUserId(json: String): FindChatIdsByUserIdQuery {
        return gson.fromJson(json, FindChatIdsByUserIdQuery::class.java)
    }

}