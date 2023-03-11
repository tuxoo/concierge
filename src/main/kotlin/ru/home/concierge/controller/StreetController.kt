package ru.home.concierge.controller

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
    fun createStreet(@Valid @RequestBody streetDto: StreetDto) =
        streetService.create(streetDto)

    @GetMapping
    fun getAllStreets(): List<StreetDto> =
        streetService.getAll()

    @GetMapping("/{id}")
    fun getStreetById(@PathVariable id: Int): StreetDto =
        streetService.getById(id)

    @PutMapping("/{id}")
    fun updateStreet(
        @PathVariable id: Int,
        @RequestParam("name") name: String?,
        @RequestParam("city") city: String?,
    ) = streetService.update(id, name, city)

    @DeleteMapping("/{id}")
    fun deleteStreet(@PathVariable id: Int) =
        streetService.delete(id)
}