package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Street
import java.time.Instant
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class DwellingDto(
    val id: Int?,

    @field:NotNull
    @field:NotEmpty
    val number: String?,

    @field:NotNull
    @field:Min(1)
    val floorNumber: Int?,

    @field:NotNull
    @field:Min(1)
    @field:Max(31)
    val startMeasuringDay: Int?,

    @field:NotNull
    @field:Min(1)
    @field:Max(31)
    val stopMeasuringDay: Int?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
) {

    fun toEntity(street: Street) = Dwelling(
        number = this.number!!,
        floorNumber = this.floorNumber!!,
        startMeasuringDay = this.startMeasuringDay!!,
        stopMeasuringDay = this.stopMeasuringDay!!,
        lastModifiedAt = Instant.now(),
        street = street,
    )
}
