package ru.home.concierge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import ru.home.concierge.config.property.ApplicationProperty

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(
    ApplicationProperty::class,
)
class ConciergeApplication

fun main(args: Array<String>) {
    runApplication<ConciergeApplication>(*args)
}
