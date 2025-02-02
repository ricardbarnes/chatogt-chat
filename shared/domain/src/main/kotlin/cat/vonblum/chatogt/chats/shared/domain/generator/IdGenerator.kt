package cat.vonblum.chatogt.chats.shared.domain.generator

import java.util.UUID

interface IdGenerator {

    fun next(): UUID

}