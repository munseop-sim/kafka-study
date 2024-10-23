package ms2709.kafka.adapter.`in`.web

import jakarta.validation.Valid
import ms2709.kafka.common.adapter.`in`.MyMessagePublishAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(
    private val myMessagePublishAdapter: MyMessagePublishAdapter
) {
    @PostMapping("/message")
    fun publishMessage(@Valid @RequestBody message: MessageRequestParam): String {
        return myMessagePublishAdapter.publishMessage(message.toCommnad()).toString()
    }
}