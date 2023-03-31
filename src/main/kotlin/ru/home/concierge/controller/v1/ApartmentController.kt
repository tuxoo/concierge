package ru.home.concierge.controller.v1

import org.springdoc.core.converters.models.PageableAsQueryParam
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
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    fun getAllApartments(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        pageable: Pageable,
    ): Page<ApartmentDto> = apartmentService.getAll(streetId, dwellingId, pageable)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getApartmentById(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): ApartmentDto = apartmentService.getById(streetId, dwellingId, id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.OK)
    fun deleteApartment(
        @PathVariable streetId: Int,
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): Unit = apartmentService.delete(streetId, dwellingId, id)
}