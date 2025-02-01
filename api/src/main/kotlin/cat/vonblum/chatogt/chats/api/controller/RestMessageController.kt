package cat.vonblum.chatogt.chats.api.controller

import cat.vonblum.chatogt.chats.api.dto.RestMessageDto
import cat.vonblum.chatogt.chats.api.mapper.RestMessageMapper
import cat.vonblum.chatogt.chats.shared.domain.command.CommandBus
import cat.vonblum.chatogt.chats.shared.domain.query.QueryBus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/messages")
class RestMessageController(
    private val commandBus: CommandBus,
    private val queryBus: QueryBus,
    private val mapper: RestMessageMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: RestMessageDto) {
        commandBus.dispatch(mapper.toCreateCommand(dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: UUID) {
        commandBus.dispatch(mapper.toDeleteCommand(id))
    }

    @GetMapping("/{chatId}")
    @ResponseStatus(HttpStatus.OK)
    fun findIds(@PathVariable chatId: UUID): RestMessageDto {
        return mapper.toRest(queryBus.ask(mapper.toFindIdsQuery(chatId)))
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable id: UUID): RestMessageDto {
        return mapper.toRest(queryBus.ask(mapper.toFindQuery(id)))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody dto: RestMessageDto) {
        commandBus.dispatch(mapper.toUpdateCommand(dto))
    }

}