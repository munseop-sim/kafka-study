package ms2709.kafka.common.application.service

import ms2709.kafka.common.application.port.`in`.MyMessagePublishCommand
import ms2709.kafka.common.application.port.`in`.MyMessagePublishUseCase
import ms2709.kafka.common.config.kafka.KafkaTopic
import ms2709.kafka.common.domain.MyMessage
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MyMessagePublishService (
    private val kafkaTemplate: KafkaTemplate<String,MyMessage>
): MyMessagePublishUseCase{
    override fun publishMyMessage(message: MyMessagePublishCommand) :MyMessage{
        sendMessage(KafkaTopic.MY_JSON_TOPIC, message.id.toString(), message.toMessage())
        return message.toMessage()
    }

    private fun sendMessage(
        topic: String,
        key:String,
        message:MyMessage
    ){
  kafkaTemplate.send(topic,key, message)
    }
}

