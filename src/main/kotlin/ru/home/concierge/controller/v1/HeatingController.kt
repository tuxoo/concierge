package ru.home.concierge.controller.v1

import io.swagger.v3.oas.annotations.Parameter
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.HeatingDto
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateHeating(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @Valid @NotNull @RequestParam("apartmentId", required = true) apartmentId: Int?,
        @RequestParam("measure") measure: Double?,
    ): Unit = heatingService.updateById(dwellingId, id, apartmentId!!, measure)
}