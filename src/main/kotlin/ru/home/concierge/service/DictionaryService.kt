package ru.home.concierge.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.MonthDto
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.model.enums.City

@Service
class DictionaryService(
    private val monthService: MonthService,
    private val yearService: YearService,
) {

    @Cacheable("city")
    fun getCities() = City.values().map {
        it.toDto()
    }

    @Cacheable("apartment-type")
    fun getApartmentTypes() = ApartmentType.values().map {
        it.toDto()
    }

    @Cacheable("year")
    fun getYears(): List<Int> = yearService.getAll().map {
        it.id
    }

    @Cacheable("month")
    fun getMonths(): List<MonthDto> = monthService.getAll().map {
        MonthDto(
            number = it.id,
            name = it.name,
            shortName = it.shortName,
        )
    }
}