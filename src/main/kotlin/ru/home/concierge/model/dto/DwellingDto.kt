package ru.home.concierge.model.dto

import org.springframework.data.annotation.LastModifiedBy
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Street
import java.time.Instant
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

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
) {

    fun toEntity(street: Street) = Dwelling(
        number = this.number!!,
        floorNumber = this.floorNumber!!,
        street = street,
    )
}
