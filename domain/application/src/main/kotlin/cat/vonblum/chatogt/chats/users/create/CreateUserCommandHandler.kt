package cat.vonblum.chatogt.chats.users.create

import cat.vonblum.chatogt.chats.shared.UserId
import cat.vonblum.chatogt.chats.shared.domain.event.EventBus
import cat.vonblum.chatogt.chats.users.User
import cat.vonblum.chatogt.chats.users.UserName

class CreateUserCommandHandler(private val eventBus: EventBus) {

    fun handle(command: CreateUserCommand): User =
        User.create(UserId(command.id), UserName(command.name)).also { user -> eventBus.publish(user.pullEvents()) }

}