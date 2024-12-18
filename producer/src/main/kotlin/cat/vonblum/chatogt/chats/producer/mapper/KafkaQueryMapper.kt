package cat.vonblum.chatogt.chats.producer.mapper

import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class KafkaQueryMapper(private val gson: Gson) {

    fun toCreateChatCommand(obj: Any): CreateChatCommand {
        return gson.fromJson(obj.toString(), CreateChatCommand::class.java)
    }

    fun toFindChatQuery(obj: Any): FindChatQuery {
        return gson.fromJson(obj.toString(), FindChatQuery::class.java)
    }

}