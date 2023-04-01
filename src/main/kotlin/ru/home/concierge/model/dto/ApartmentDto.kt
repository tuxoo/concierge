package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Apartment
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Floor
import ru.home.concierge.model.enums.ApartmentType
import java.time.Instant
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class ApartmentDto(
    val id: Int?,

    @field:NotNull
    @field:Min(1)
    val number: Int?,

    val floor: Int?,

    val owner: String?,

    val phone: String?,

    val type: String?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
) {

    fun toEntity(dwelling: Dwelling, floor: Floor) = Apartment(
        number = this.number!!,
        type = if (type != null) ApartmentType.valueOf(this.type) else null,
        lastModifiedAt = Instant.now(),
        dwelling = dwelling,
        floor = floor,
    )

    companion object {
        fun fromEntity(apartment: Apartment) =
            ApartmentDto(
                id = apartment.id,
                number = apartment.number,
                floor = apartment.floor.number,
                owner = apartment.owner,
                phone = apartment.phone,
                type = apartment.type?.name,
                createdAt = apartment.createdAt,
                lastModifiedAt = apartment.lastModifiedAt,
            )
    }


}