package ru.home.concierge.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.model.dto.ApartmentFilter
import ru.home.concierge.model.entity.Apartment
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.ApartmentRepository
import ru.home.concierge.repository.specification.ApartmentSpecification
import java.time.Instant

@Service
class ApartmentService(
    private val apartmentRepository: ApartmentRepository,
    private val dwellingService: DwellingService,
    private val floorService: FloorService,
) {
    fun create(dwellingId: Int, floorId: Int, apartmentDto: ApartmentDto) {
        val dwelling = dwellingService.findByIdOrThrow(dwellingId)
        floorService.findByIdOrThrow(floorId).run {
            apartmentRepository.save(apartmentDto.toEntity(dwelling, this))
        }
    }

    fun getAll(filter: ApartmentFilter, pageable: Pageable): Page<ApartmentDto> =
        dwellingService.findByIdOrThrow(filter.dwellingId).run {
            apartmentRepository.findAll(ApartmentSpecification.byFilter(filter), pageable)
        }.map { ApartmentDto.fromEntity(it) }

    fun getById(dwellingId: Int, id: Int): ApartmentDto =
        findByDwellingIdAndIdOrThrow(dwellingId, id).run { ApartmentDto.fromEntity(this) }

    fun findByDwellingIdAndIdOrThrow(dwellingId: Int, id: Int): Apartment =
        dwellingService.findByIdOrThrow(dwellingId).sections.asSequence().map {
            it.floors
        }.flatten()
            .map { it.apartments }.flatten()
            .find { it.id == id }
            ?: throw NotFoundException("The Apartment not found by id [$id]")

    fun updateById(
        dwellingId: Int,
        id: Int,
        apartmentNumber: Int?,
        owner: String?,
        phone: String?,
        type: String?
    ) {
        apartmentRepository.save(
            findByDwellingIdAndIdOrThrow(dwellingId, id).run {
                Apartment(
                    id = this.id,
                    number = this.number,
                    owner = owner ?: this.owner,
                    phone = phone ?: this.owner,
                    type = if (type != null) ApartmentType.valueOf(type) else null,
                    dwelling = this.dwelling,
                    floor = this.floor,
                    createdAt = this.createdAt,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(dwellingId: Int, id: Int) {
        findByDwellingIdAndIdOrThrow(dwellingId, id).run {
            apartmentRepository.deleteById(this.id ?: id)
        }
    }
}