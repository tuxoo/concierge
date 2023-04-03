package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Floor
import ru.home.concierge.model.entity.Section
import java.time.Instant
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FloorDto(
    val id: Int?,

    val section: Int?,

    @field:NotNull
    @field:NotEmpty
    val number: Int?,

    val createdAt: Instant?,

    val apartments: List<ApartmentDto>? = null,
) {

    fun toEntity(section: Section) = Floor(
        number = this.number!!,
        section = section,
    )

    companion object {
        fun fromEntity(floor: Floor) =
            FloorDto(
                id = floor.id,
                section = floor.section.number,
                number = floor.number,
                createdAt = floor.createdAt,
                apartments = floor.apartments.map { apartment ->
                    ApartmentDto.fromEntity(apartment)
                }
            )
    }
}
