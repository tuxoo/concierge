package ru.home.concierge.model.dto

data class HeatingFilter(
    val dwellingId: Int?,
    val apartmentId: Int?,
    val month: Int?,
    val year: Int?,
)
