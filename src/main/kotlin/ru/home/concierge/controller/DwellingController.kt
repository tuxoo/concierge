package ru.home.concierge.controller

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
    fun createDwelling(@PathVariable streetId: Int, @Valid @RequestBody dwellingDto: DwellingDto) =
        dwellingService.create(streetId, dwellingDto)

    @GetMapping
    fun getAllDwellings(@PathVariable streetId: Int): List<DwellingDto> =
        dwellingService.getAll(streetId)

    @GetMapping("/{id}")
    fun getDwellingById(@PathVariable streetId: Int, @PathVariable id: Int): DwellingDto =
        dwellingService.getById(id)

    @PutMapping("/{id}")
    fun updateDwelling(
        @PathVariable streetId: String,
        @PathVariable id: Int,
        @RequestParam("floorNumber", required = true) floorNumber: Int?,
    ) = dwellingService.update(id, floorNumber)

    @DeleteMapping("/{id}")
    fun deleteDwelling(@PathVariable streetId: String, @PathVariable id: Int) =
        dwellingService.delete(id)
}