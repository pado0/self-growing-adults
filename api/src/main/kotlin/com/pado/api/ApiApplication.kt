package com.pado.api

import com.pado.domain.annotation.EnableDomain
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

object MainDefaults {
    val PROPS = mapOf(
        "spring.application.name" to "api",
        "spring.profiles.active" to "local",
        "management.endpoints.web.exposure.include" to "info,health",
        "logging.level.root" to "info"
    )
}

@SpringBootApplication
@EnableDomain
@ConfigurationPropertiesScan
@EntityScan(basePackages = ["com.pado.domain"])
@EnableJpaRepositories(basePackages = ["com.pado.domain"])
class Main : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder =
        builder.properties(MainDefaults.PROPS).sources(Main::class.java)
}

fun main(args: Array<String>) {
    SpringApplicationBuilder().properties(MainDefaults.PROPS).sources(Main::class.java).run(*args)
}
