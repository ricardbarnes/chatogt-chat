package cat.vonblum.chatogt.chats.api.controller

import cat.vonblum.chatogt.chats.api.dto.RestUserDto
import cat.vonblum.chatogt.chats.api.mapper.RestUserMapper
import cat.vonblum.chatogt.chats.chats.find.FindChatIdsByUserIdResponse
import cat.vonblum.chatogt.chats.shared.domain.command.CommandBus
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/users")
class RestUserController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestUserMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: RestUserDto) {
        commandBus.dispatch(mapper.toCreateCommand(dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: UUID) {
        commandBus.dispatch(mapper.toDeleteCommand(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody dto: RestUserDto) {
        commandBus.dispatch(mapper.toUpdateCommand(dto))
    }

    @GetMapping("/{id}/chats")
    fun findChatsByUserId(@PathVariable id: UUID): RestUserDto {
        return queryBus.ask(mapper.toFindByUserIdQuery(id))
            ?.let { mapper.toDto(it as FindChatIdsByUserIdResponse) }
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Chats not found for user with ID: $id"
            )
    }

}