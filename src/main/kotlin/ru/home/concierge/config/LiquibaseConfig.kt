package ru.home.concierge.config

import liquibase.integration.spring.SpringLiquibase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.home.concierge.config.property.LiquibaseProperty
import javax.sql.DataSource

@Configuration(proxyBeanMethods = false)
class LiquibaseConfig {

    @Bean
    fun springLiquibase(
        property: LiquibaseProperty,
        dataSource: DataSource,
    ): SpringLiquibase = SpringLiquibase().apply {
        this.changeLog = property.changeLog
        this.dataSource = dataSource
        this.defaultSchema = property.defaultSchema
        this.contexts = property.contexts
    }
}