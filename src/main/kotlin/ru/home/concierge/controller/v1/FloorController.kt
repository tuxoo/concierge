package ru.home.concierge.controller.v1

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.service.FloorService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/section/{sectionId}/floor")
class FloorController(
    private val floorService: FloorService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFloors(
        @PathVariable sectionId: Int,
        @Valid @RequestBody floors: Array<FloorDto>,
    ): Unit = floorService.createAll(sectionId, floors)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllFloors(
        @PathVariable sectionId: Int,
    ): List<FloorDto> = floorService.getAll(sectionId)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getDwellingById(
        @PathVariable sectionId: Int,
        @PathVariable id: Int,
    ): FloorDto = floorService.getById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateDwelling(
        @PathVariable sectionId: Int,
        @PathVariable id: Int,
        @RequestParam("number") number: Int?,
    ): FloorDto = floorService.updateById(id, number)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteDwelling(
        @PathVariable sectionId: Int,
        @PathVariable id: Int,
    ): Unit = floorService.delete(id)
}