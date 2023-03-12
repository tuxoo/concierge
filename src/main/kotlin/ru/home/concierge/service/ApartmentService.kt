package ru.home.concierge.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.model.entity.Apartment
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.ApartmentRepository
import java.time.Instant

@Service
class ApartmentService(
    private val apartmentRepository: ApartmentRepository,
    private val dwellingService: DwellingService,
    private val floorService: FloorService,
) {
    fun createAll(streetId: Int, dwellingId: Int, floorId: Int, apartmentDto: ApartmentDto): Unit =
        floorService.findByStreetIdAndDwellingIdAndId(streetId, dwellingId, floorId).run {
            apartmentRepository.save(apartmentDto.toEntity(this))
        }

    fun getAll(streetId: Int, dwellingId: Int, pageable: Pageable): Page<ApartmentDto> =
        apartmentRepository.findAll(pageable).map {
            ApartmentDto(
                id = it.id,
                number = it.number,
                owner = it.owner,
                phone = it.phone,
                type = it.type?.name,
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        }

    fun getById(streetId: Int, dwellingId: Int, id: Int): ApartmentDto =
        findById(streetId, dwellingId, id).run {
            ApartmentDto(
                id = this.id,
                number = this.number,
                owner = this.owner,
                phone = this.phone,
                type = this.type?.name,
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findById(streetId: Int, dwellingId: Int, id: Int): Apartment =
        dwellingService.findById(streetId, dwellingId).floors.map {
            it.apartments
        }.flatten().find {
            it.id == id
        } ?: throw NotFoundException("The Apartment not found by id [$id]")

    fun updateById(
        streetId: Int,
        dwellingId: Int,
        id: Int,
        apartmentNumber: Int?,
        owner: String?,
        phone: String?,
        type: String?
    ) {
        apartmentRepository.save(
            findById(streetId, dwellingId, id).run {
                Apartment(
                    id = this.id,
                    number = this.number,
                    owner = owner ?: this.owner,
                    phone = phone ?: this.owner,
                    type = if (type != null) ApartmentType.valueOf(type) else null,
                    floor = this.floor,
                    createdAt = this.createdAt,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(streetId: Int, dwellingId: Int, id: Int) {
        findById(streetId, dwellingId, id).run {
            apartmentRepository.deleteById(this.id ?: id)
        }
    }
}