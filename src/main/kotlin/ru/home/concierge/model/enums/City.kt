package ru.home.concierge.model.enums

import ru.home.concierge.model.dto.CityDto

enum class City(
    private val shortName: String,
    private val timeZone: String,
) {
    VORONEZH("VRN", "Europe/Moscow"),
    MOSCOW("MSK", "Europe/Moscow");

    companion object {
        fun fromShortName(city: String): City =
            City.values().firstOrNull {
                it.shortName == city
            } ?: error("Unsupported city")
    }

    fun toDto() = CityDto(
        name = this.name,
        shortName = this.shortName,
        timeZone = this.timeZone,
    )

    fun getShortName() = this.shortName

    fun getTimeZone() = this.timeZone
}