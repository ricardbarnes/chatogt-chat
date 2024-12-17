package cat.vonblum.chatogt.chats.users

import cat.vonblum.chatogt.chats.shared.UserId

interface FindingUsers {

    fun findById(id: UserId): User

}