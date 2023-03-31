package ru.home.concierge.model.enums

import ru.home.concierge.model.dto.ApartmentTypeDto

enum class Role(
    private val description: String
) {
    ADMIN("Администратор"),
    TENANT("Жилец"),
}