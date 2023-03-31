package ru.home.concierge.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "application")
@ConstructorBinding
data class ApplicationProperty(
    val url : String,
    val apiPath : String,
)
