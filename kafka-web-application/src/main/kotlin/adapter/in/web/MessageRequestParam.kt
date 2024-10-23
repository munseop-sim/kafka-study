package ms2709.kafka.adapter.`in`.web

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import ms2709.kafka.common.application.port.`in`.MyMessagePublishCommand

class MessageRequestParam {
    @Positive
    @NotBlank
    var age:Int? = null

    @Positive
    @NotBlank
    var id:Int? =null

    @NotEmpty
    var name:String? = null

    var content:String? = null

    fun toCommnad(): MyMessagePublishCommand {
        return MyMessagePublishCommand(
            this.id!!,
            this.age!!,
            this.name!!,
            this.content
        )
    }
}