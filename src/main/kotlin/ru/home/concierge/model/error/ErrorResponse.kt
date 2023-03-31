package ru.home.concierge.model.error

import io.swagger.v3.oas.annotations.media.Schema
import java.time.Instant

data class ErrorResponse(
    @Schema(description = "error message")
    val message: String,

    @Schema(description = "error time")
    val errorTime: Instant,
)
