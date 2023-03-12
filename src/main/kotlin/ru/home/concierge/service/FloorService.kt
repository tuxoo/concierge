package ru.home.concierge.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.model.entity.Floor
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.FloorRepository
import java.time.Instant

@Service
class FloorService(
    private val floorRepository: FloorRepository,
    private val dwellingService: DwellingService,
) {

    @Transactional
    fun createAll(streetId: Int, dwellingId: Int, floorsDto: Array<FloorDto>) {
        dwellingService.findById(streetId, dwellingId).run {
            floorsDto.forEach {
                floorRepository.save(it.toEntity(this))
            }
        }
    }

    fun getAll(streetId: Int, dwellingId: Int): List<FloorDto> =
        dwellingService.findById(streetId, dwellingId).floors.map { dwelling ->
            FloorDto(
                id = dwelling.id,
                number = dwelling.number,
                apartmentNumber = dwelling.apartmentNumber,
                createdAt = dwelling.createdAt,
                lastModifiedAt = dwelling.lastModifiedAt,
                apartments = dwelling.apartments.map { apartment ->
                    ApartmentDto(
                        id = apartment.id,
                        number = apartment.number,
                        owner = apartment.owner,
                        phone = apartment.phone,
                        type = apartment.type?.name,
                        createdAt = apartment.createdAt,
                        lastModifiedAt = apartment.lastModifiedAt,
                    )
                }
            )
        }

    fun getById(streetId: Int, dwellingId: Int, id: Int): FloorDto =
        findByStreetIdAndDwellingIdAndId(streetId, dwellingId, id).run {
            FloorDto(
                id = this.id,
                number = this.number,
                apartmentNumber = this.apartmentNumber,
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findByStreetIdAndDwellingIdAndId(streetId: Int, dwellingId: Int, id: Int): Floor =
        dwellingService.findById(streetId, dwellingId).floors?.find {
            it.id == id
        } ?: throw NotFoundException("The floor not found by id [$id]")

    fun updateById(streetId: Int, dwellingId: Int, id: Int, apartmentNumber: Int?) {
        floorRepository.save(
            findByStreetIdAndDwellingIdAndId(streetId, dwellingId, id).run {
                Floor(
                    id = this.id,
                    number = this.number,
                    apartmentNumber = apartmentNumber ?: this.apartmentNumber,
                    createdAt = this.createdAt,
                    dwelling = this.dwelling,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(streetId: Int, dwellingId: Int, id: Int) =
        findByStreetIdAndDwellingIdAndId(streetId, dwellingId, id).run {
            floorRepository.deleteById(this.id ?: id)
        }
}