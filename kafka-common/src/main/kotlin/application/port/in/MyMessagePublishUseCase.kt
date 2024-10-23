package ms2709.kafka.common.application.port.`in`

import ms2709.kafka.common.domain.MyMessage

interface MyMessagePublishUseCase {
    fun publishMyMessage(message: MyMessagePublishCommand): MyMessage
}