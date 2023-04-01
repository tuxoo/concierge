package ru.home.concierge.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.DwellingDto
import ru.home.concierge.model.dto.DwellingFilter
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.DwellingRepository
import ru.home.concierge.repository.specification.DwellingSpecification
import java.time.Instant

@Service
class DwellingService(
    private val dwellingRepository: DwellingRepository,
    private val streetService: StreetService,
) {

    fun create(streetId: Int, dwellingDto: DwellingDto): Unit =
        streetService.findById(streetId).run {
            dwellingRepository.save(dwellingDto.toEntity(this))
        }

    fun getAll(filter: DwellingFilter, pageable: Pageable): Page<DwellingDto> =
        streetService.findById(filter.streetId).run {
            dwellingRepository.findAll(DwellingSpecification.byFilter(filter), pageable)
        }.map {
            DwellingDto.fromEntity(it)
        }


    fun getById(id: Int): DwellingDto =
        findByIdOrThrow(id).run {
            DwellingDto.fromEntity(this)
        }

    fun findByIdOrThrow(id: Int): Dwelling = dwellingRepository.findById(id).orElseThrow {
        throw NotFoundException("The dwelling not found by id [$id]")
    }

    fun update(
        id: Int,
        sectionNumber: Int?,
        startMeasuringDay: Int?,
        stopMeasuringDay: Int?
    ) {
        dwellingRepository.save(
            findByIdOrThrow(id).run {
                Dwelling(
                    id = this.id,
                    number = this.number,
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

    fun delete(id: Int) =
        findByIdOrThrow(id).run {
            dwellingRepository.deleteById(this.id ?: id)
        }
}

