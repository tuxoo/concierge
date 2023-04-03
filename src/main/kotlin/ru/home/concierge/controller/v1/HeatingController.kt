package ru.home.concierge.controller.v1

import io.swagger.v3.oas.annotations.Parameter
import org.springdoc.core.converters.models.PageableAsQueryParam
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.HeatingDto
import ru.home.concierge.model.dto.HeatingFilter
import ru.home.concierge.service.HeatingService
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
@RestController
@RequestMapping("/api/v1/dwelling/{dwellingId}/heating")
class HeatingController(
    private val heatingService: HeatingService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createHeating(
        @PathVariable dwellingId: Int,
        @Valid @NotNull @RequestParam("apartmentId", required = true) apartmentId: Int?,
        @Valid @RequestBody heatingDto: HeatingDto,
    ): Unit = heatingService.create(dwellingId, apartmentId!!, heatingDto)

    @GetMapping
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    fun getAllHeating(
        @PathVariable dwellingId: Int,
        @RequestParam("apartmentId") apartmentId: Int?,
        @RequestParam("month") month: Int?,
        @RequestParam("year") year: Int?,
        @Parameter(hidden = true) pageable: Pageable,
    ): Page<HeatingDto> = heatingService.getAll(
        HeatingFilter(
            dwellingId = dwellingId,
            apartmentId = apartmentId,
            month = month,
            year = year,
        ), pageable
    )

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateHeating(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @Valid @NotNull @RequestParam("apartmentId", required = true) apartmentId: Int?,
        @RequestParam("measure") measure: Double?,
    ): HeatingDto = heatingService.updateById(dwellingId, id, apartmentId!!, measure)
}