package cat.vonblum.chatogt.chats.shared.domain.generator

interface HashGenerator {

    fun hash(value: String): String

}