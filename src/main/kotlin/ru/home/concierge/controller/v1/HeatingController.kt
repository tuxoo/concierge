package ru.home.concierge.controller.v1

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.HeatingDto
import ru.home.concierge.service.HeatingService
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
@RestController
@RequestMapping("/api/v1/street/{streetId}/dwelling/{dwellingId}/heating")
class HeatingController(
    private val heatingService: HeatingService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createHeating(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @Valid @NotNull @RequestParam("apartmentId", required = true) apartmentId: Int?,
        @Valid @RequestBody heatingDto: HeatingDto,
    ): Unit = heatingService.create(streetId, dwellingId, apartmentId!!, heatingDto)

    @GetMapping("/current")
    @ResponseStatus(HttpStatus.OK)
    fun getByCurrenPeriod(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
    ): List<HeatingDto> = heatingService.getByCurrenPeriod(streetId, dwellingId)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateHeating(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @Valid @NotNull @RequestParam("apartmentId", required = true) apartmentId: Int?,
        @RequestParam("measure") measure: Double?,
    ): Unit = heatingService.updateById(streetId, dwellingId, id, apartmentId!!, measure)
}