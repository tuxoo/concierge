package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Apartment
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

    val owner: String?,

    val phone: String?,

    val type: String?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
) {

    fun toEntity(floor: Floor) = Apartment(
        number = this.number!!,
        type = if (type != null) ApartmentType.valueOf(this.type) else null,
        lastModifiedAt = Instant.now(),
        floor = floor,
    )
}