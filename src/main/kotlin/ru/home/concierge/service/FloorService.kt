package ru.home.concierge.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.home.concierge.model.dto.FloorDto
import ru.home.concierge.model.entity.Floor
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.FloorRepository

@Service
class FloorService(
    private val floorRepository: FloorRepository,
    private val sectionService: SectionService,
) {

    @Transactional
    fun createAll(sectionId: Int, floorsDto: Array<FloorDto>): Unit =
        sectionService.findByIdOrThrow(sectionId).run {
            floorsDto.forEach {
                floorRepository.save(it.toEntity(this))
            }
        }

    fun getAll(sectionId: Int): List<FloorDto> =
        sectionService.findByIdOrThrow(sectionId).floors
            .map { FloorDto.fromEntity(it) }
            .sortedBy { it.number }

    fun getById(id: Int): FloorDto =
        findByIdOrThrow(id).run {
            FloorDto.fromEntity(this)
        }

    fun findByIdOrThrow(id: Int): Floor =
        floorRepository.findById(id).orElseThrow {
            NotFoundException("The floor not found by id [$id]")
        }

    fun updateById(id: Int, apartmentNumber: Int?) =
        FloorDto.fromEntity(floorRepository.save(
            findByIdOrThrow(id).run {
                Floor(
                    id = this.id,
                    number = this.number,
                    apartmentNumber = apartmentNumber ?: this.apartmentNumber,
                    createdAt = this.createdAt,
                    section = this.section,
                )
            }
        ))

    fun delete(id: Int) =
        findByIdOrThrow(id).run {
            floorRepository.deleteById(this.id ?: id)
        }
}