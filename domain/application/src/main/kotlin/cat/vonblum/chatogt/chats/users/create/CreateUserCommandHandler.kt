package cat.vonblum.chatogt.chats.users.create

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus
import cat.vonblum.chatogt.chats.users.User

class CreateUserCommandHandler(private val eventBus: EventBus) {

    fun handle(command: CreateUserCommand): User = User.create(
        UserId(command.id),
        command.contactIds.map { UserId(it) }.toMutableSet(),
    ).also { user -> eventBus.publish(user.pullEvents()) }

}