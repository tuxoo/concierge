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
    val sectionNumber: Int?,

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
        sectionNumber = this.sectionNumber!!,
        startMeasuringDay = this.startMeasuringDay!!,
        stopMeasuringDay = this.stopMeasuringDay!!,
        lastModifiedAt = Instant.now(),
        street = street,
    )

    companion object {
        fun fromEntity(dwelling: Dwelling) = DwellingDto(
            id = dwelling.id,
            number = dwelling.number,
            sectionNumber = dwelling.sectionNumber,
            startMeasuringDay = dwelling.startMeasuringDay,
            stopMeasuringDay = dwelling.stopMeasuringDay,
            createdAt = dwelling.createdAt,
            lastModifiedAt = dwelling.lastModifiedAt,
            sections = dwelling.sections.map { section ->
                SectionDto(
                    id = section.id,
                    number = section.number,
                    floorNumber = section.floorNumber,
                    createdAt = section.createdAt,
                    floors = section.floors.map { floor ->
                        FloorDto(
                            id = floor.id,
                            number = floor.number,
                            apartmentNumber = floor.apartmentNumber,
                            createdAt = floor.createdAt,
                        )
                    }
                )
            }
        )
    }
}
