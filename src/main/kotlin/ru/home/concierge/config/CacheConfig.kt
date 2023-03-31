package ru.home.concierge.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration(proxyBeanMethods = false)
class CacheConfig {

    @Bean
    fun cache(): Caffeine<Any, Any> =
        Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES)


    @Bean
    fun cacheManager(
        caffeine: Caffeine<Any, Any>
    ) = CaffeineCacheManager().apply {
        this.setCaffeine(caffeine)
    }
}