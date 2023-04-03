package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Section
import java.time.Instant
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class SectionDto(
    val id: Int?,

    @field:NotNull
    @field:Min(1)
    val number: Int?,

    val createdAt: Instant?,

    val floors: List<FloorDto>?,
) {

    fun toEntity(dwelling: Dwelling) = Section(
        number = this.number!!,
        dwelling = dwelling,
    )

    companion object {
        fun fromEntity(section: Section) =
            SectionDto(
                id = section.id,
                number = section.number,
                createdAt = section.createdAt,
                floors = section.floors.map { floor ->
                    FloorDto.fromEntity(floor)
                }
            )
    }
}
