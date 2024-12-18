package cat.vonblum.chatogt.chats.producer.adapter.messages

import cat.vonblum.chatogt.chats.messages.Message
import cat.vonblum.chatogt.chats.messages.ReportingMessages
import cat.vonblum.chatogt.chats.shared.infrastructure.annotation.DrivenAdapter
import org.springframework.stereotype.Component

@DrivenAdapter
@Component
class FbiReportingMessages : ReportingMessages {

    override fun report(message: Message) {
        println("Message: $message reported to the FBI")
    }

}