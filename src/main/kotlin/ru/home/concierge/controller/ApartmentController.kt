package ru.home.concierge.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.service.ApartmentService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/street/{streetId}/dwelling/{dwellingId}/floor/{floorId}/apartment")
class ApartmentController(
    private val apartmentService: ApartmentService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable floorId: Int,
        @Valid @RequestBody apartmentDto: ApartmentDto,
    ): Unit = apartmentService.createAll(streetId, dwellingId, floorId, apartmentDto)

    @GetMapping
    fun getAllApartments(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable floorId: Int,
    ): List<ApartmentDto> = apartmentService.getAll(streetId, dwellingId, floorId)

    @GetMapping("/{id}")
    fun getApartmentById(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable floorId: Int,
        @PathVariable id: Int,
    ): ApartmentDto = apartmentService.getById(streetId, dwellingId, floorId, id)

    @PutMapping("/{id}")
    fun updateApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable floorId: Int,
        @PathVariable id: Int,
        @RequestParam("number") number: Int?,
        @RequestParam("owner") owner: String?,
        @RequestParam("type") type: String?,
    ): Unit = apartmentService.update(streetId, dwellingId, floorId, id, number, owner, type)

    @DeleteMapping("/{id}")
    fun deleteApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable floorId: Int,
        @PathVariable id: Int,
    ): Unit = apartmentService.delete(streetId, dwellingId, floorId, id)
}