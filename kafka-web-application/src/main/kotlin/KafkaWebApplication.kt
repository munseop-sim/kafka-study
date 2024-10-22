package ms2709.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaWebApplication

fun main(args: Array<String>) {
    runApplication<KafkaWebApplication>(*args)
}

