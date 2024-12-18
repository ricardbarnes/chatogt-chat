package cat.vonblum.chatogt.chats.chats

interface SavingChats {

    fun save(chat: Chat)

    fun save(chats: List<Chat>)

}