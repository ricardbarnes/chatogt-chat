package cat.vonblum.chatogt.chats.consumer.config

import cat.vonblum.chatogt.chats.shared.infrastructure.config.SpringSharedKafkaConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [SpringSharedKafkaConfig::class])
class SpringConsumerConfig