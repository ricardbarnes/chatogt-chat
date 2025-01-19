package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.shared.domain.query.Query
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaUserQueryMapper(private val gson: Gson) {

    fun toDto(query: Query): String? = gson.toJson(query)

}