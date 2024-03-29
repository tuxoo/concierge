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

    val street: String?,

    @field:NotNull
    @field:NotEmpty
    val number: String?,

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

    val sections: List<SectionDto>?,
) {

    fun toEntity(street: Street) = Dwelling(
        number = this.number!!,
        startMeasuringDay = this.startMeasuringDay!!,
        stopMeasuringDay = this.stopMeasuringDay!!,
        lastModifiedAt = Instant.now(),
        street = street,
    )

    companion object {
        fun fromEntity(dwelling: Dwelling) = DwellingDto(
            id = dwelling.id,
            street = dwelling.street.name,
            number = dwelling.number,
            startMeasuringDay = dwelling.startMeasuringDay,
            stopMeasuringDay = dwelling.stopMeasuringDay,
            createdAt = dwelling.createdAt,
            lastModifiedAt = dwelling.lastModifiedAt,
            sections = dwelling.sections.map { section ->
                SectionDto.fromEntity(section)
            }
        )
    }
}
