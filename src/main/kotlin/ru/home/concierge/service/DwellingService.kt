package ru.home.concierge.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.home.concierge.model.dto.DwellingDto
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.repository.DwellingRepository
import java.time.Instant

@Service
class DwellingService(
    private val dwellingRepository: DwellingRepository,
    private val streetService: StreetService,
) {

    @Transactional
    fun create(streetId: Int, dwellingDto: DwellingDto) {
        streetService.findById(streetId).run {
            dwellingRepository.save(dwellingDto.toEntity(this))
        }
    }

    @Transactional(readOnly = true)
    fun getAll(streetId: Int): List<DwellingDto> =
        streetService.findById(streetId).run {
            dwellingRepository.findAllByStreet(this).map {
                DwellingDto(
                    id = it.id,
                    number = it.number,
                    floorNumber = it.floorNumber,
                    createdAt = it.createdAt,
                )
            }
        }

    fun getById(id: Int): DwellingDto =
        findById(id).run {
            DwellingDto(
                id = this.id,
                number = this.number,
                floorNumber = this.floorNumber,
                createdAt = this.createdAt,
            )
        }

    fun findById(id: Int): Dwelling = dwellingRepository.findById(id).orElseThrow {
        error("the dwelling not found by id $id")
    }

    @Transactional
    fun update(id: Int, floorNumber: Int?) {
        dwellingRepository.save(
            findById(id).run {
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

    fun delete(id: Int) = dwellingRepository.deleteById(id)
}