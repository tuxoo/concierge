package ru.home.concierge.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.home.concierge.config.property.ApplicationProperty

@Configuration(proxyBeanMethods = false)
class SwaggerConfig(
    private val property: ApplicationProperty,
) {

    @Bean
    fun openApi(
    ): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Concierge Application")
                .contact(
                    Contact()
                        .name("Eugene Krivtsov")
                ).version("v1")
        ).run {
            this.servers(listOf(Server().url(property.url + property.apiPath)))
        }

    @Bean
    fun publicApi(
    ): GroupedOpenApi = GroupedOpenApi.builder()
        .group("API")
        .pathsToMatch("/api/**")
        .build()

    @Bean
    fun actuatorApi(
    ): GroupedOpenApi = GroupedOpenApi.builder()
        .group("Actuator")
        .pathsToMatch("/actuator/**")
        .build()
}