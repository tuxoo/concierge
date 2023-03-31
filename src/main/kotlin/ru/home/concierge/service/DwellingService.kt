package ru.home.concierge.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    fun getAll(streetId: Int, pageable: Pageable): Page<DwellingDto> =
        dwellingRepository.findAll(pageable).map {
            DwellingDto(
                id = it.id,
                number = it.number,
                floorNumber = it.floorNumber,
                sectionNumber = it.sectionNumber,
                startMeasuringDay = it.startMeasuringDay,
                stopMeasuringDay = it.stopMeasuringDay,
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        }

    fun getById(streetId: Int, id: Int): DwellingDto =
        findById(streetId, id).run {
            DwellingDto(
                id = this.id,
                number = this.number,
                floorNumber = this.floorNumber,
                sectionNumber = this.sectionNumber,
                startMeasuringDay = this.startMeasuringDay,
                stopMeasuringDay = this.stopMeasuringDay,
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findById(streetId: Int, id: Int): Dwelling = streetService.findById(streetId).run {
        dwellings.find { it.id == id } ?: throw NotFoundException("The street not found by id [$id]")
    }

    fun update(
        streetId: Int,
        id: Int,
        floorNumber: Int?,
        sectionNumber: Int?,
        startMeasuringDay: Int?,
        stopMeasuringDay: Int?
    ) {
        dwellingRepository.save(
            findById(streetId, id).run {
                Dwelling(
                    id = this.id,
                    number = this.number,
                    floorNumber = floorNumber ?: this.floorNumber,
                    sectionNumber = sectionNumber ?: this.sectionNumber,
                    startMeasuringDay = startMeasuringDay ?: this.startMeasuringDay,
                    stopMeasuringDay = stopMeasuringDay ?: this.stopMeasuringDay,
                    createdAt = this.createdAt,
                    street = this.street,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(streetId: Int, id: Int) =
        findById(streetId, id).run {
            dwellingRepository.deleteById(this.id ?: id)
        }
}