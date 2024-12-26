package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toFindChatQuery(json: String): FindChatQuery {
        return gson.fromJson(json, FindChatQuery::class.java)
    }

}