package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chats.delete.DeleteChatCommand
import cat.vonblum.chatogt.chats.chats.find.FindChatQuery
import cat.vonblum.chatogt.chats.chats.update.UpdateChatCommand
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestChatMapper {

    fun toCreateCommand(dto: RestChatDto): CreateChatCommand = CreateChatCommand(dto.id, dto.userId)

    fun toDeleteCommand(id: UUID): DeleteChatCommand = DeleteChatCommand(id)

    fun toFindQuery(userId: UUID): FindChatQuery = FindChatQuery(userId)

    fun toUpdateCommand(dto: RestChatDto): Command = TODO()

    fun toRest(response: Response?): RestChatDto = TODO()

}