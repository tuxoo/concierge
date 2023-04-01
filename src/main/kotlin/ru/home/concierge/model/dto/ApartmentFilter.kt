package ru.home.concierge.model.dto

data class ApartmentFilter(
    val dwellingId: Int,
    val floorId: Int?,
    val number: Int?,
    val owner: String?,
    val phone: String?,
)
