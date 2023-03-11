package ru.home.concierge.model.error

data class ValidationError(
    val field: String,
    val constraint: String,
)
