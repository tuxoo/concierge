package ru.home.concierge.controller.v1

import io.swagger.v3.oas.annotations.Parameter
import org.springdoc.core.converters.models.PageableAsQueryParam
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.StreetDto
import ru.home.concierge.service.StreetService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/street")
class StreetController(
    private val streetService: StreetService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createStreet(
        @Valid @RequestBody streetDto: StreetDto,
    ): Unit = streetService.create(streetDto)

    @GetMapping
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    fun getAllStreets(@Parameter(hidden = true) pageable: Pageable): Page<StreetDto> = streetService.getAll(pageable)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getStreetById(
        @PathVariable id: Int,
    ): StreetDto = streetService.getById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateStreet(
        @PathVariable id: Int,
        @RequestParam("name") name: String?,
        @RequestParam("city") city: String?,
    ): StreetDto = streetService.updateById(id, name, city)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteStreet(
        @PathVariable id: Int,
    ): Unit = streetService.delete(id)
}