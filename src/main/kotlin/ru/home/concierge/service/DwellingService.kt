package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.DwellingDto
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.DwellingRepository
import java.time.Instant

@Service
class DwellingService(
    private val dwellingRepository: DwellingRepository,
    private val streetService: StreetService,
) {

    fun create(streetId: Int, dwellingDto: DwellingDto) {
        streetService.findById(streetId).run {
            dwellingRepository.save(dwellingDto.toEntity(this))
        }
    }

    fun getAll(streetId: Int): List<DwellingDto> =
        streetService.findById(streetId).dwellings?.map {
            DwellingDto(
                id = it.id,
                number = it.number,
                floorNumber = it.floorNumber,
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        } ?: emptyList()

    fun getById(streetId: Int, id: Int): DwellingDto =
        findByStreetIdAndId(streetId, id).run {
            DwellingDto(
                id = this.id,
                number = this.number,
                floorNumber = this.floorNumber,
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findByStreetIdAndId(streetId: Int, id: Int): Dwelling = streetService.findById(streetId).run {
        dwellings?.find { it.id == id } ?: throw NotFoundException("The street not found by id [$id]")
    }

    fun update(streetId: Int, id: Int, floorNumber: Int?) {
        dwellingRepository.save(
            findByStreetIdAndId(streetId, id).run {
                Dwelling(
                    id = this.id,
                    number = this.number,
                    floorNumber = floorNumber ?: this.floorNumber,
                    createdAt = this.createdAt,
                    street = this.street,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(streetId: Int, id: Int) =
        findByStreetIdAndId(streetId, id).run {
            dwellingRepository.deleteById(this.id ?: id)
        }
}