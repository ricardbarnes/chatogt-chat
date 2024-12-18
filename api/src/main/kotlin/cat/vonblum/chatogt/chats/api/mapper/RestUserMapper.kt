package cat.vonblum.chatogt.chats.api.mapper

import cat.vonblum.chatogt.chats.api.dto.RestUserDto
import cat.vonblum.chatogt.chats.chats.create.CreateChatCommand
import cat.vonblum.chatogt.chats.shared.domain.command.Command
import cat.vonblum.chatogt.chats.shared.domain.query.Response
import cat.vonblum.chatogt.chats.users.delete.DeleteUserCommand
import cat.vonblum.chatogt.chats.users.find.FindUserQuery
import org.springframework.stereotype.Component
import java.util.*

@Component
class RestUserMapper {

    fun toCreateCommand(dto: RestUserDto): CreateChatCommand = TODO()

    fun toDeleteCommand(id: UUID): DeleteUserCommand = TODO()

    fun toFindQuery(userId: UUID): FindUserQuery = TODO()

    fun toUpdateCommand(dto: RestUserDto): Command = TODO()

    fun toRest(response: Response?): RestUserDto = TODO()

}