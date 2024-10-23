package ms2709.kafka.adapter.`in`

import ms2709.kafka.common.domain.MyMessage
import ms2709.kafka.common.config.kafka.KafkaTopic
import ms2709.kafka.common.config.LogDelegate
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener

import org.springframework.stereotype.Component

@Component
class MyConsumer {
    private val log by LogDelegate()

    @KafkaListener(
        topics = [KafkaTopic.MY_JSON_TOPIC],
        groupId = "test-consumer-group",
    )
    fun accept(message: ConsumerRecord<String, MyMessage>) {
        log.info("key :: {}, message :: {}",message.key(), message.value())
    }}