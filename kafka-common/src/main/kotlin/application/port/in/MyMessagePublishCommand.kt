package ms2709.kafka.common.application.port.`in`

import ms2709.kafka.common.domain.MyMessage

data class MyMessagePublishCommand(
    val id:Int,
    val age:Int,
    val name:String,
    val content:String?
){
    fun toMessage(): MyMessage {
        return MyMessage(id, age, name, content)
    }
}