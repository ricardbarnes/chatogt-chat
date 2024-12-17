package cat.vonblum.chatogt.chats.chats

interface StoringChats {

    fun store(chat: Chat)

    fun store(chats: List<Chat>)

}