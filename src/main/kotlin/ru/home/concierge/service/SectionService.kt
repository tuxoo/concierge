package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.SectionDto
import ru.home.concierge.model.entity.Section
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.SectionRepository

@Service
class SectionService(
    private val sectionRepository: SectionRepository,
    private val dwellingService: DwellingService,
) {

    fun create(dwellingId: Int, sectionDto: SectionDto): Unit =
        dwellingService.findByIdOrThrow(dwellingId).run {
            sectionRepository.save(sectionDto.toEntity(this))
        }

    fun getAll(dwellingId: Int): List<SectionDto> =
        dwellingService.findByIdOrThrow(dwellingId).sections
            .map { SectionDto.fromEntity(it) }
            .sortedBy { it.number }

    fun getById(id: Int): SectionDto =
        findByIdOrThrow(id).run { SectionDto.fromEntity(this) }

    fun findByIdOrThrow(id: Int): Section = sectionRepository.findById(id).orElseThrow {
        throw NotFoundException("The section not found by id [$id]")
    }

    fun update(id: Int, number: Int?, floorNumber: Int?) = SectionDto.fromEntity(
        sectionRepository.save(
            findByIdOrThrow(id).run {
                Section(
                    id = this.id,
                    number = number ?: this.number,
                    floorNumber = floorNumber ?: this.floorNumber,
                    createdAt = this.createdAt,
                    dwelling = this.dwelling,
                )
            }
        )
    )

    fun delete(id: Int) =
        findByIdOrThrow(id).run {
            sectionRepository.deleteById(this.id ?: id)
        }
}