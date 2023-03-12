package ru.home.concierge.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.service.ApartmentService
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
@RestController
@RequestMapping("/api/v1/street/{streetId}/dwelling/{dwellingId}/apartment")
class ApartmentController(
    private val apartmentService: ApartmentService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @Valid @NotNull @RequestParam("floorId", required = true) floorId: Int?,
        @Valid @RequestBody apartmentDto: ApartmentDto,
    ): Unit = apartmentService.createAll(streetId, dwellingId, floorId!!, apartmentDto)

    @GetMapping
    fun getAllApartments(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        pageable: Pageable,
    ): Page<ApartmentDto> = apartmentService.getAll(streetId, dwellingId, pageable)

    @GetMapping("/{id}")
    fun getApartmentById(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): ApartmentDto = apartmentService.getById(streetId, dwellingId, id)

    @PutMapping("/{id}")
    fun updateApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @RequestParam("number") number: Int?,
        @RequestParam("owner") owner: String?,
        @RequestParam("phone") phone: String?,
        @RequestParam("type") type: String?,
    ): Unit = apartmentService.updateById(streetId, dwellingId, id, number, owner, phone, type)

    @DeleteMapping("/{id}")
    fun deleteApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): Unit = apartmentService.delete(streetId, dwellingId, id)
}