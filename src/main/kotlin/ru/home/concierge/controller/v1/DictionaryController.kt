package ru.home.concierge.controller.v1

import org.springframework.http.HttpStatus
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
    @ResponseStatus(HttpStatus.OK)
    fun getDwellings(): List<CityDto> =
        dictionaryService.getCities()

    @GetMapping("/apartment-type")
    @ResponseStatus(HttpStatus.OK)
    fun getApartmentTypes(): List<ApartmentTypeDto> =
        dictionaryService.getApartmentTypes()

    @GetMapping("/year")
    @ResponseStatus(HttpStatus.OK)
    fun getYears(): List<Int> = dictionaryService.getYears()

    @GetMapping("/month")
    @ResponseStatus(HttpStatus.OK)
    fun getMonths(): List<MonthDto> = dictionaryService.getMonths()
}