package ru.home.concierge.model.error

import java.time.Instant

data class ErrorResponse(
    val message: String,
    val errorTime: Instant,
)
