package ms2709.kafka.adapter.`in`.web

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @Operation( method = "Get", summary = "Hello World Test")
    @GetMapping("/hello")
    fun hello():String{
        return "Hello World!"
    }
}