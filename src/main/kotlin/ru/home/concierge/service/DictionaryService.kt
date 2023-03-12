package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.MonthDto
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.model.enums.City

@Service
class DictionaryService(
    private val monthService: MonthService,
    private val yearService: YearService,
) {

    fun getCities() = City.values().map {
        it.toDto()
    }

    fun getApartmentTypes() = ApartmentType.values().map {
        it.toDto()
    }

    fun getYears(): List<Int> = yearService.getAll().map {
        it.id
    }

    fun getMonths(): List<MonthDto> = monthService.getAll().map {
        MonthDto(
            number = it.id,
            name = it.name,
            shortName = MonthDto.getShortName(it.id)
        )
    }
}