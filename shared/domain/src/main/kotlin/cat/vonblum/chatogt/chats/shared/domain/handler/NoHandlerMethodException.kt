package cat.vonblum.chatogt.chats.shared.domain.handler

class NoHandlerMethodException(message: String) : HandlerException(message) {

    companion object {

        fun becauseOf(handler: Any): NoHandlerMethodException =
            NoHandlerMethodException("No handle method was found in class \"${handler::class.simpleName}\"")

    }

}