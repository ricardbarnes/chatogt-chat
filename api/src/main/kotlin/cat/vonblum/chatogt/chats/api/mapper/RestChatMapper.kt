package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.chat.create.CreateChatCommand
import cat.vonblum.chatogt.chats.chat.delete.DeleteChatCommand
import cat.vonblum.chatogt.chats.chat.find.FindChatIdsQuery
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestChatMapper {

    fun toCreateCommand(dto: RestChatDto): CreateChatCommand {
        TODO("Not yet implemented")
    }

    fun toDeleteCommand(id: UUID): DeleteChatCommand {
        TODO("Not yet implemented")
    }

    fun toFindIdsQuery(id: UUID): FindChatIdsQuery {
        TODO("Not yet implemented")
    }

    fun toUpdateCommand(dto: RestChatDto): Command {
        TODO("Not yet implemented")
    }

    fun toRest(dispatch: Response?): RestChatDto {
        TODO("Not yet implemented")
    }

}