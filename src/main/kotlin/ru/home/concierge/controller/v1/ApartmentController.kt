package ru.home.concierge.controller.v1

import io.swagger.v3.oas.annotations.Parameter
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
@RequestMapping("/api/v1/dwelling/{dwellingId}/apartment")
class ApartmentController(
    private val apartmentService: ApartmentService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createApartment(
        @PathVariable dwellingId: Int,
        @Valid @NotNull @RequestParam("floorId", required = true) floorId: Int?,
        @Valid @RequestBody apartmentDto: ApartmentDto,
    ): Unit = apartmentService.create(dwellingId, floorId!!, apartmentDto)

    @GetMapping
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    fun getAllApartments(
        @PathVariable dwellingId: Int,
        @Parameter(hidden = true) pageable: Pageable,
    ): Page<ApartmentDto> = apartmentService.getAll(dwellingId, pageable)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getApartmentById(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): ApartmentDto = apartmentService.getById(dwellingId, id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateApartment(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @RequestParam("number") number: Int?,
        @RequestParam("owner") owner: String?,
        @RequestParam("phone") phone: String?,
        @RequestParam("type") type: String?,
    ): Unit = apartmentService.updateById(dwellingId, id, number, owner, phone, type)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteApartment(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): Unit = apartmentService.delete(dwellingId, id)
}