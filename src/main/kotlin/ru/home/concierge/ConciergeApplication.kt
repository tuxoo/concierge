package ru.home.concierge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.home.concierge.config.property.ApplicationProperty

@SpringBootApplication
@EnableConfigurationProperties(
    ApplicationProperty::class,
)
class ConciergeApplication

fun main(args: Array<String>) {
    runApplication<ConciergeApplication>(*args)
}
