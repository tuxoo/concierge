package ru.home.concierge.config

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration(proxyBeanMethods = false)
class ObjectMapperConfig {

    @Bean
    fun jsonCustomizer(
    ): Jackson2ObjectMapperBuilderCustomizer =
        Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->
            builder.serializationInclusion(
                JsonInclude.Include.NON_NULL
            )
        }
}