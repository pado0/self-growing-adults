package com.pado.learninghistory.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.FluxSink
import java.util.*

@RestController
@RequestMapping("/api/v1")
class ProduceTestController(
    private val processorSink: FluxSink<String>
) {
    @GetMapping
    fun produce() {
        this.processorSink.next(UUID.randomUUID().toString())
    }
}