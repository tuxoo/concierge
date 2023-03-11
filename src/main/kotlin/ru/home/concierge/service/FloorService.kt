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
    fun createAll(dwellingId: Int, floorsDto: Array<FloorDto>) {
        floorsDto.forEach {
            dwellingService.findById(dwellingId).run {
                floorRepository.save(it.toEntity(this))
            }
        }
    }

    fun getAll(dwellingId: Int): List<FloorDto> =
        dwellingService.findById(dwellingId).run {
            floorRepository.findAllByDwelling(this).map {
                FloorDto(
                    id = it.id,
                    number = it.number,
                    apartmentNumber = it.apartmentNumber,
                    createdAt = it.createdAt,
                )
            }
        }

    fun getById(id: Int): FloorDto =
        findById(id).run {
            FloorDto(
                id = this.id,
                number = this.number,
                apartmentNumber = this.apartmentNumber,
                createdAt = this.createdAt,
            )
        }

    fun findById(id: Int): Floor = floorRepository.findById(id).orElseThrow {
        error("the floor not found by id $id")
    }

    @Transactional
    fun update(id: Int, apartmentNumber: Int?) {
        floorRepository.save(
            findById(id).run {
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

    fun delete(id: Int) = floorRepository.deleteById(id)
}