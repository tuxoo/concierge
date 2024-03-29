package ru.home.concierge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import ru.home.concierge.config.property.ApplicationProperty
import ru.home.concierge.config.property.LiquibaseProperty

@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties(
    ApplicationProperty::class,
    LiquibaseProperty::class,
)
class ConciergeApplication

fun main(args: Array<String>) {
    runApplication<ConciergeApplication>(*args)
}
