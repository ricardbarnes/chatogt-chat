package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestUserChatIdsDto
import cat.vonblum.chatogt.chats.api.dto.RestUserDto
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdQuery
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.users.create.CreateUserCommand
import cat.vonblum.chatogt.chats.users.delete.DeleteUserCommand
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestUserMapper {

    fun toCreateCommand(dto: RestUserDto): CreateUserCommand {
        return CreateUserCommand(dto.id)
    }

    fun toDeleteCommand(id: UUID): DeleteUserCommand {
        TODO()
    }

    fun toUpdateCommand(dto: RestUserDto): Command {
        TODO()
    }

    fun toFindByUserIdQuery(id: UUID): FindChatIdsByUserIdQuery {
        return FindChatIdsByUserIdQuery(id)
    }

    fun toDto(response: FindChatIdsByUserIdResponse): RestUserChatIdsDto {
        return RestUserChatIdsDto(
            response.userId,
            response.chatIds.map { it.toString() }.toList()
        )
    }

}