package ru.home.concierge.model.dto

import ru.home.concierge.model.entity.Street
import ru.home.concierge.model.enums.City
import java.time.Instant
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class StreetDto(
    val id: Int?,

    @field:NotNull
    @field:NotEmpty
    val name: String?,

    @field:NotNull
    @field:NotEmpty
    val city: String?,

    val createdAt: Instant?,

    val lastModifiedAt: Instant?,
) {

    fun toEntity() = Street(
        name = this.name!!,
        city = City.fromShortName(city!!),
    )
}