package ru.home.concierge.controller

import org.springframework.web.bind.annotation.*
import ru.home.concierge.model.dto.ApartmentTypeDto
import ru.home.concierge.model.dto.CityDto
import ru.home.concierge.model.dto.MonthDto
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

    @GetMapping("/year")
    fun getYears(): List<Int> = dictionaryService.getYears()

    @GetMapping("/month")
    fun getMonths(): List<MonthDto> = dictionaryService.getMonths()
}