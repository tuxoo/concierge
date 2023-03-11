package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.StreetDto
import ru.home.concierge.model.entity.Street
import ru.home.concierge.model.enums.City
import ru.home.concierge.repository.StreetRepository
import java.time.Instant

@Service
class StreetService(
    private val streetRepository: StreetRepository,
) {

    fun create(streetDto: StreetDto) {
        streetRepository.save(streetDto.toEntity())
    }

    fun getAll(): List<StreetDto> =
        streetRepository.findAll().map {
            StreetDto(
                id = it.id,
                name = it.name,
                city = it.city.getShortName(),
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        }

    fun getById(id: Int): StreetDto =
        findById(id).run {
            StreetDto(
                id = this.id,
                name = this.name,
                city = this.city.getShortName(),
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findById(id: Int): Street = streetRepository.findById(id).orElseThrow {
        error("the street not found by id $id")
    }

    fun update(id: Int, name: String?, city: String?) {
        streetRepository.save(
            findById(id).run {
                Street(
                    id = this.id,
                    name = name ?: this.name,
                    city = if (city != null) City.fromShortName(city) else this.city,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(id: Int) = streetRepository.deleteById(id)
}