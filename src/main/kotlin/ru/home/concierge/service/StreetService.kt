package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.StreetDto
import ru.home.concierge.model.entity.Street
import ru.home.concierge.model.enums.City
import ru.home.concierge.repository.StreetRepository

@Service
class StreetService(
    private val streetRepository: StreetRepository,
) {

    fun createStreet(streetDto: StreetDto) {
        streetRepository.save(streetDto.toEntity())
    }

    fun getAllStreets(): List<StreetDto> =
        streetRepository.findAll().map {
            StreetDto(
                id = it.id,
                name = it.name,
                city = it.city.shortName,
                createdAt = it.createdAt,

            )
        }

    fun getById(id: Int): StreetDto =
        streetRepository.findById(id).map {
            StreetDto(
                id = it.id,
                name = it.name,
                city = it.city.shortName,
                createdAt = it.createdAt,
            )
        }.orElseThrow()

    fun updateStreet(id: Int, name: String, city: String) {
        streetRepository.save(
            Street(
                id = id,
                name = name,
                city = City.fromShortName(city)
            )
        )
    }

    fun deleteStreet(id: Int) = streetRepository.deleteById(id)
}