package ru.home.concierge.controller.v1

import org.springdoc.core.converters.models.PageableAsQueryParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.SectionDto
import ru.home.concierge.service.SectionService
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/dwelling/{dwellingId}/section")
class SectionController(
    private val sectionService: SectionService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createSection(
        @PathVariable dwellingId: Int,
        @Valid @RequestBody sectionDto: SectionDto,
    ): Unit = sectionService.create(dwellingId, sectionDto)

    @GetMapping
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    fun getAllSections(
        @PathVariable dwellingId: Int,
    ): List<SectionDto> = sectionService.getAll(dwellingId)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getSectionById(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): SectionDto = sectionService.getById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateSection(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
        @RequestParam("number") number: Int?,
        @RequestParam("floorNumber") floorNumber: Int?,
    ): SectionDto = sectionService.update(id, number, floorNumber)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteSection(
        @PathVariable dwellingId: Int,
        @PathVariable id: Int,
    ): Unit = sectionService.delete(id)
}