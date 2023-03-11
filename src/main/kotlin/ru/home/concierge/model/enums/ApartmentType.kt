package ru.home.concierge.model.enums

import ru.home.concierge.model.dto.ApartmentTypeDto

enum class ApartmentType(
    private val description: String
) {
    ONE_ROOM_APARTMENT("Однокомнантная кватрира"),
    TWO_ROOM_APARTMENT("Двухкомнантная кватрира"),
    THREE_ROOM_APARTMENT("Трехкомнантная кватрира");

    fun toDto() = ApartmentTypeDto(
        name = this.name,
        description = this.description,
    )
}