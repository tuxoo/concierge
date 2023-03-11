package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.model.enums.City

@Service
class DictionaryService {

    fun getCities() = City.values().map {
        it.toDto()
    }

    fun getApartmentTypes() = ApartmentType.values().map {
        it.toDto()
    }
}