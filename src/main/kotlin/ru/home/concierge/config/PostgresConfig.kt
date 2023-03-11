package ru.home.concierge.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.StringUtils

//@Configuration(proxyBeanMethods = false)
//class PostgresConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    fun dataSource(
//        properties: DataSourceProperties,
//    ): HikariDataSource {
//        return properties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
//            .apply {
//                if (StringUtils.hasText(properties.name)) {
//                    poolName = properties.name
//                }
//            }
//    }
//}