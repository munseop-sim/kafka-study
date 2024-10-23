package ms2709.kafka.common.config.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig(
    private val kafkaProperties: KafkaProperties,
    @Qualifier("kafkaStringProperties") private val kafkaStringProperties: KafkaProperties
) {
    @Bean
    @Primary
    fun producerFactory(): ProducerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = kafkaProperties.producer.keySerializer
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = kafkaProperties.producer.valueSerializer
        props[ProducerConfig.ACKS_CONFIG] = kafkaProperties.producer.acks ?: "-1"
        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    @Primary
    fun kafkaTemplate(): KafkaTemplate<String, *> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    @Qualifier("kafkaStringListenerContainerFactory")
    fun kafkaStringListenerContainerFactory(): ProducerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaStringProperties.bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = kafkaStringProperties.producer.keySerializer
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = kafkaStringProperties.producer.valueSerializer
        props[ProducerConfig.ACKS_CONFIG] = kafkaStringProperties.producer.acks ?: "-1"
        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    @Qualifier("kafkaStringTemplate")
    fun kafkaStringTemplate(): KafkaTemplate<String, *> {
        return KafkaTemplate(kafkaStringListenerContainerFactory())
    }
}