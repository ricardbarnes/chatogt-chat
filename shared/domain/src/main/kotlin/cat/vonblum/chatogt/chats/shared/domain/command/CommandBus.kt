package cat.vonblum.chatogt.chats.shared.domain.command

interface CommandBus {

    fun dispatch(command: Command)

}