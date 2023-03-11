package ru.home.concierge.model.enums

enum class City(
    val shortName: String
) {
    VORONEZH("VRN"),
    MOSCOW("MSK");

    companion object {
        fun fromShortName(city: String): City =
            City.values().firstOrNull {
                it.shortName == city
            } ?: error("Unsupported city")
    }
}