package ru.home.concierge.model.dto

import java.time.Instant
import javax.validation.constraints.NotNull

data class HeatingDto(
    val id: Int?,

    @field:NotNull
    val measure: Double?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
)