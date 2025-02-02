package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestMessageDto
import cat.vonblum.chatogt.chats.messages.create.CreateMessageCommand
import cat.vonblum.chatogt.chats.messages.delete.DeleteMessageCommand
import cat.vonblum.chatogt.chats.messages.find.FindMessageIdsQuery
import cat.vonblum.chatogt.chats.messages.find.FindMessageQuery
import cat.vonblum.chatogt.chats.messages.update.UpdateMessageCommand
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestMessageMapper {

    fun toCreateCommand(dto: RestMessageDto): CreateMessageCommand {
        return CreateMessageCommand(
            dto.chatId,
            dto.authorId,
            dto.content
        )
    }

    fun toDeleteCommand(id: UUID): DeleteMessageCommand {
        TODO("Not yet implemented")
    }

    fun toFindIdsQuery(chatId: UUID): FindMessageIdsQuery {
        TODO("Not yet implemented")
    }

    fun toFindQuery(id: UUID): FindMessageQuery {
        TODO("Not yet implemented")
    }

    fun toUpdateCommand(dto: RestMessageDto): UpdateMessageCommand {
        TODO("Not yet implemented")
    }

    fun toRest(ask: Response?): RestMessageDto {
        TODO("Not yet implemented")
    }

}