package com.pado.domain.datasource

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

// 차후에 db 관련 인프라 모듈로 config 및 설정 분리
@Configuration
class GaDbConfig {

    @FlywayDataSource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.gadb")
    fun gaDbDataSource(): DataSource = DataSourceBuilder.create().build()
}