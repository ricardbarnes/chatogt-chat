package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chat.delete.DeleteChatCommand
import cat.vonblum.chatogt.chats.chat.find.FindChatIdsQuery
import cat.vonblum.chatogt.chats.chat.update.UpdateChatCommand
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestChatMapper {

    fun toCreateCommand(dto: RestChatDto): CreateChatCommand = CreateChatCommand(dto.id(), dto.userId())

    fun toDeleteCommand(id: UUID): DeleteChatCommand = DeleteChatCommand(id)

    fun toFindIdsQuery(userId: UUID): FindChatIdsQuery = FindChatIdsQuery(userId)

    fun toUpdateCommand(dto: RestChatDto): Command = UpdateChatCommand(dto.id(), dto.status())

    fun toRest(response: Response?): RestChatDto = TODO()

}