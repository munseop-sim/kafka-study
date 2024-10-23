package ms2709.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class KafkaJsonConsumerConfig (
    private val kafkaProperties: KafkaProperties,
    @Qualifier("kafkaStringProperties") private val kafkaStringProperties: KafkaProperties
){



    @Bean
    @Primary
    fun consumerFactory(): ConsumerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = kafkaProperties.consumer.keyDeserializer
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = kafkaProperties.consumer.valueDeserializer
        props[JsonDeserializer.TRUSTED_PACKAGES] = "*"
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "latest"
        props[ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG] = "false"
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    @Primary
    fun kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, Any>
    ): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = consumerFactory
        factory.setConcurrency(1)

        return factory
    }


    @Bean
    @Qualifier("stringConsumerFactory")
    fun stringConsumerFactory(): ConsumerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaStringProperties.bootstrapServers
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = kafkaStringProperties.consumer.keyDeserializer
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = kafkaStringProperties.consumer.valueDeserializer
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "latest"
        props[ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG] = "false"
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    @Qualifier("stringKafkaListenerContainerFactory")
    fun stringKafkaListenerContainerFactory(
        @Qualifier("stringConsumerFactory") consumerFactory: ConsumerFactory<String?, Any?>
    ): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = consumerFactory
        factory.setConcurrency(1)

        return factory
    }
}