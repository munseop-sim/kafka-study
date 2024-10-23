package ms2709.kafka.common.config.kafka

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.kafka.annotation.EnableKafka

@Configuration
@EnableKafka
class KafkaPropertyConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.kafka.json")
    fun kafkaProperties(): KafkaProperties {
        return KafkaProperties()
    }

    @Bean
    @Qualifier("kafkaStringProperties")
    @ConfigurationProperties("spring.kafka.string")
    fun kafkaStringProperties(): KafkaProperties {
        return KafkaProperties()
    }

}