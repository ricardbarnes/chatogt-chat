package cat.vonblum.chatogt.chats.api.controller

import cat.vonblum.chatogt.chats.api.dto.RestChatDto
import cat.vonblum.chatogt.chats.api.mapper.RestChatMapper
import cat.vonblum.chatogt.chats.shared.domain.command.CommandBus
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/chats")
class RestChatController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestChatMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: RestChatDto) =
        commandBus.dispatch(mapper.toCreateCommand(dto))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: UUID) =
        commandBus.dispatch(mapper.toDeleteCommand(id))

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable userId: UUID): RestChatDto =
        mapper.toRest(queryBus.ask(mapper.toFindIdsQuery(userId)))

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody dto: RestChatDto) =
        commandBus.dispatch(mapper.toUpdateCommand(dto))

}
