package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaUserQueryMapper(private val gson: Gson) {

    fun toDto(query: FindUserQuery): String? = gson.toJson(query)

}