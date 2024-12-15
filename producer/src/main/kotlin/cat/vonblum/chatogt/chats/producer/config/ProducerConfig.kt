package cat.vonblum.chatogt.chats.producer.config

import cat.vonblum.chatogt.chats.shared.infrastructure.config.SharedConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SharedConfig::class])
class ProducerConfig