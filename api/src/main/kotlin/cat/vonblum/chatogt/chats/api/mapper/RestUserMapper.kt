package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestUserDto
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.users.create.CreateUserCommand
import cat.vonblum.chatogt.chats.users.delete.DeleteUserCommand
import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import cat.vonblum.chatogt.chats.users.find.FindUserResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestUserMapper {

    fun toCreateCommand(dto: RestUserDto): CreateUserCommand = CreateUserCommand(
        dto.id,
        dto.chatIds
    )

    fun toDeleteCommand(id: UUID): DeleteUserCommand = TODO()

    fun toFindQuery(userId: UUID): FindUserQuery = FindUserQuery(userId)

    fun toUpdateCommand(dto: RestUserDto): Command = TODO()

    fun toRest(response: Response?): RestUserDto {
        val findUserResponse = response as FindUserResponse
        return RestUserDto(
            findUserResponse.id,
            findUserResponse.chatIds
        )
    }

}