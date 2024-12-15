package cat.vonblum.chatogt.chats.shared.infrastructure.config

import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SharedConfig {

    @Bean
    fun gson(): Gson {
        return Gson()
    }

}