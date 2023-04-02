package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Heating
import java.time.Instant
import javax.validation.constraints.NotNull

data class HeatingDto(
    val id: Int?,

    @field:NotNull
    val measure: Double?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,

    val year: Int?,

    val month: String?,
) {

    companion object {
        fun fromEntity(heating: Heating) =
            HeatingDto(
                id = heating.id,
                measure = heating.measure,
                createdAt = heating.createdAt,
                lastModifiedAt = heating.lastModifiedAt,
                year = heating.year.id,
                month = heating.month.shortName,
            )
    }
}