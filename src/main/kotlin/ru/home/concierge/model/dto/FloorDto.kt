package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Floor
import ru.home.concierge.model.entity.Section
import java.time.Instant
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FloorDto(
    val id: Int?,

    @field:NotNull
    @field:NotEmpty
    val number: Int?,

    @field:NotNull
    @field:NotEmpty
    val apartmentNumber: Int?,

    val createdAt: Instant?,

    val apartments: List<ApartmentDto>? = null,
) {

    fun toEntity(section: Section) = Floor(
        number = this.number!!,
        apartmentNumber = this.apartmentNumber!!,
        section = section,
    )

    companion object {
        fun fromEntity(floor: Floor) =
            FloorDto(
                id = floor.id,
                number = floor.number,
                apartmentNumber = floor.apartmentNumber,
                createdAt = floor.createdAt,
                apartments = floor.apartments.map { apartment ->
                    ApartmentDto(
                        id = apartment.id,
                        number = apartment.number,
                        owner = apartment.owner,
                        phone = apartment.phone,
                        type = apartment.type?.name,
                        createdAt = apartment.createdAt,
                        lastModifiedAt = apartment.lastModifiedAt,
                    )
                }
            )
    }
}
