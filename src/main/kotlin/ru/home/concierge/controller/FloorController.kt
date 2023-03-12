package ru.home.concierge.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.service.FloorService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/street/{streetId}/dwelling/{dwellingId}/floor")
class FloorController(
    private val floorService: FloorService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFloors(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @Valid @RequestBody floorsDto: Array<FloorDto>,
    ): Unit = floorService.createAll(streetId, dwellingId, floorsDto)

    @GetMapping
    fun getAllFloors(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
    ): List<FloorDto> = floorService.getAll(streetId, dwellingId)

    @GetMapping("/{id}")
    fun getDwellingById(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): FloorDto = floorService.getById(streetId, dwellingId, id)

    @PutMapping("/{id}")
    fun updateDwelling(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @RequestParam("apartmentNumber") apartmentNumber: Int?,
    ): Unit = floorService.updateById(streetId, dwellingId, id, apartmentNumber)

    @DeleteMapping("/{id}")
    fun deleteDwelling(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): Unit = floorService.delete(streetId, dwellingId, id)
}