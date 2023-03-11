package ru.home.concierge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.home.concierge.model.dto.ApartmentTypeDto
import ru.home.concierge.model.dto.CityDto
import ru.home.concierge.service.DictionaryService

@RestController
@RequestMapping("/api/v1/dictionary")
class DictionaryController(
    private val dictionaryService: DictionaryService,
) {

    @GetMapping("/city")
    fun getDwellings(): List<CityDto> =
        dictionaryService.getCities()

    @GetMapping("/apartment-type")
    fun getApartmentTypes(): List<ApartmentTypeDto> =
        dictionaryService.getApartmentTypes()
}