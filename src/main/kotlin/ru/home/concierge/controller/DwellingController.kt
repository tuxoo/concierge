package ru.home.concierge.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.DwellingDto
import ru.home.concierge.service.DwellingService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/street/{streetId}/dwelling")
class DwellingController(
    private val dwellingService: DwellingService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDwelling(
        @PathVariable streetId: Int,
        @Valid @RequestBody dwellingDto: DwellingDto,
    ): Unit = dwellingService.create(streetId, dwellingDto)

    @GetMapping
    fun getAllDwellings(
        @PathVariable streetId: Int,
        pageable: Pageable,
    ): Page<DwellingDto> = dwellingService.getAll(streetId, pageable)

    @GetMapping("/{id}")
    fun getDwellingById(
        @PathVariable streetId: Int,
        @PathVariable id: Int,
    ): DwellingDto = dwellingService.getById(streetId, id)

    @PutMapping("/{id}")
    fun updateDwelling(
        @PathVariable streetId: Int,
        @PathVariable id: Int,
        @RequestParam("floorNumber") floorNumber: Int?,
        @RequestParam("startMeasuringDay") startMeasuringDay: Int?,
        @RequestParam("stopMeasuringDay") stopMeasuringDay: Int?,
    ): Unit = dwellingService.update(streetId, id, floorNumber, startMeasuringDay, stopMeasuringDay)

    @DeleteMapping("/{id}")
    fun deleteDwelling(
        @PathVariable streetId: Int,
        @PathVariable id: Int,
    ): Unit = dwellingService.delete(streetId, id)
}