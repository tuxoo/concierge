package ru.home.concierge.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.DwellingDto
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.model.dto.StreetDto
import ru.home.concierge.service.FloorService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/dwelling/{dwellingId}/floor")
class FloorController(
    private val floorService: FloorService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFloors(
        @PathVariable dwellingId: Int,
        @Valid @RequestBody floorsDto: Array<FloorDto>,
    ) = floorService.createAll(dwellingId, floorsDto)

    @GetMapping
    fun getAllFloors(@PathVariable dwellingId: Int): List<FloorDto> =
        floorService.getAll(dwellingId)

    @GetMapping("/{id}")
    fun getDwellingById(@PathVariable dwellingId: Int, @PathVariable id: Int): FloorDto =
        floorService.getById(id)

    @PutMapping("/{id}")
    fun updateDwelling(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @RequestParam("apartmentNumber") apartmentNumber: Int?,
    ) = floorService.update(id, apartmentNumber)

    @DeleteMapping("/{id}")
    fun deleteDwelling(@PathVariable dwellingId: Int, @PathVariable id: Int) =
        floorService.delete(id)
}