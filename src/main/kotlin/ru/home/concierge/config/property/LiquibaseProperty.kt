package ru.home.concierge.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.liquibase")
data class LiquibaseProperty(
    val defaultSchema: String,
    val changeLog: String,
    val contexts: String,
)
