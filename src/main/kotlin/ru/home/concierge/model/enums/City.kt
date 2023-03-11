package ru.home.concierge.model.enums

import ru.home.concierge.model.dto.CityDto

enum class City(
    private val shortName: String
) {
    VORONEZH("VRN"),
    MOSCOW("MSK");

    companion object {
        fun fromShortName(city: String): City =
            City.values().firstOrNull {
                it.shortName == city
            } ?: error("Unsupported city")
    }

    fun toDto() = CityDto(
        name = this.name,
        shortName = this.shortName,
    )

    fun getShortName() = this.shortName
}