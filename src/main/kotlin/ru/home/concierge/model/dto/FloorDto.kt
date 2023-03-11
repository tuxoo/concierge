package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Floor
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

    val lastModifiedAt: Instant?,
) {

    fun toEntity(dwelling: Dwelling) = Floor(
        number = this.number!!,
        apartmentNumber = this.apartmentNumber!!,
        dwelling = dwelling,
    )
}
