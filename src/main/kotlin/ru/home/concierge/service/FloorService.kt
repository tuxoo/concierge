package ru.home.concierge.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.model.entity.Floor
import ru.home.concierge.repository.FloorRepository
import java.time.Instant

@Service
class FloorService(
    private val floorRepository: FloorRepository,
    private val dwellingService: DwellingService,
) {

    @Transactional
    fun createAll(streetId: Int, dwellingId: Int, floorsDto: Array<FloorDto>) {
        dwellingService.findByStreetIdAndId(streetId, dwellingId).run {
            floorsDto.forEach {
                floorRepository.save(it.toEntity(this))
            }
        }
    }

    fun getAll(streetId: Int, dwellingId: Int): List<FloorDto> =
        dwellingService.findByStreetIdAndId(streetId, dwellingId).run {
            floorRepository.findAllByDwelling(this).map {
                FloorDto(
                    id = it.id,
                    number = it.number,
                    apartmentNumber = it.apartmentNumber,
                    createdAt = it.createdAt,
                    lastModifiedAt = it.lastModifiedAt,
                )
            }
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

    fun findByStreetIdAndDwellingIdAndId(streetId: Int, dwellingId: Int, id: Int): Floor {
        val dwelling = dwellingService.findByStreetIdAndId(streetId, dwellingId)
        return dwelling.floors?.find { it.id == id } ?: error("the unknown floor with id [$id]")
    }

    fun update(streetId: Int, dwellingId: Int, id: Int, apartmentNumber: Int?) {
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
        dwellingService.findByStreetIdAndId(streetId, dwellingId).run {
            floorRepository.deleteById(id)
        }
}