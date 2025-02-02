package cat.vonblum.chatogt.chats.shared.infrastructure.generator

import cat.vonblum.chatogt.chats.shared.domain.generator.IdGenerator
import java.util.*

class GenericIdGenerator : IdGenerator {

    override fun next(): UUID {
        return UUID.randomUUID()
    }

}