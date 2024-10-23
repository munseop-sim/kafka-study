package ms2709.kafka.common.adapter.`in`

import ms2709.kafka.common.application.port.`in`.MyMessagePublishCommand
import ms2709.kafka.common.application.port.`in`.MyMessagePublishUseCase
import ms2709.kafka.common.domain.MyMessage
import org.springframework.stereotype.Component

@Component
class MyMessagePublishAdapter (
    private val myMessagePublishUseCase: MyMessagePublishUseCase
){
    fun publishMessage(messageCommand: MyMessagePublishCommand) :MyMessage {
        return myMessagePublishUseCase.publishMyMessage(messageCommand)
    }
}