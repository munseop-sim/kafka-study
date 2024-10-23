package ms2709.kafka.common.domain

import ms2709.kafka.common.application.port.`in`.MyMessagePublishCommand

data class MyMessage (
    val id:Int,
    val age:Int,
    val name:String,
    val content:String?
){

}