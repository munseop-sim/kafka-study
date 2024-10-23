package ms2709.kafka.common

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaCommonApplication

fun main(args: Array<String>) {
    runApplication<KafkaCommonApplication>(*args)
}