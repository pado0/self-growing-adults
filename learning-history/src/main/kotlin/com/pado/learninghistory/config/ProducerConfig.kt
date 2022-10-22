package com.pado.learninghistory.config

import org.apache.logging.log4j.util.Supplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink


@Configuration
class ProducerConfig {
    @Bean
    fun processor(): EmitterProcessor<String> =
        EmitterProcessor.create<String>()

    @Bean
    fun processorSink(processor: EmitterProcessor<String>): FluxSink<String> {
        return processor.sink(FluxSink.OverflowStrategy.DROP)
    }

    @Bean
    fun kotlinSupplier(processor: EmitterProcessor<String>) = Supplier<Flux<String>> {
        processor
    }
}