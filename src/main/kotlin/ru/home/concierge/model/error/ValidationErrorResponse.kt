package ru.home.concierge.model.error

import java.time.Instant


data class ValidationErrorResponse(
    val message: String = "Incorrect input body",
    val errorTime: Instant = Instant.now(),
    val validationErrors: List<ValidationError>,
) {

}