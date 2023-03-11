package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.ApartmentDto
import ru.home.concierge.model.entity.Apartment
import ru.home.concierge.model.enums.ApartmentType
import ru.home.concierge.repository.ApartmentRepository
import java.time.Instant

@Service
class ApartmentService(
    private val apartmentRepository: ApartmentRepository,
    private val floorService: FloorService,
) {
    fun createAll(streetId: Int, dwellingId: Int, floorId: Int, apartmentDto: ApartmentDto): Unit =
        floorService.findByStreetIdAndDwellingIdAndId(streetId, dwellingId, floorId).run {
            apartmentRepository.save(apartmentDto.toEntity(this))
        }

    fun getAll(streetId: Int, dwellingId: Int, floorId: Int): List<ApartmentDto> =
        floorService.findByStreetIdAndDwellingIdAndId(streetId, dwellingId, floorId).apartments?.map {
            ApartmentDto(
                id = it.id,
                number = it.number,
                owner = it.owner,
                type = it.type?.name,
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        } ?: error("apartments not found")

    fun getById(streetId: Int, dwellingId: Int, floorId: Int, id: Int): ApartmentDto {
        val apartment = floorService.findByStreetIdAndDwellingIdAndId(streetId, dwellingId, floorId).apartments?.find {
            it.id == id
        } ?: error("")

        return ApartmentDto(
            id = apartment.id,
            number = apartment.number,
            owner = apartment.owner,
            type = apartment.type?.name,
            createdAt = apartment.createdAt,
            lastModifiedAt = apartment.lastModifiedAt,
        )
    }

    fun findByStreetIdAndDwellingIdAndFloorIdAndId(streetId: Int, dwellingId: Int, floorId: Int, id: Int): Apartment {
        val floor = floorService.findByStreetIdAndDwellingIdAndId(streetId, dwellingId, floorId)
        return floor.apartments?.find { it.id == id } ?: error("the unknown floor with id [$id]")
    }

    fun update(
        streetId: Int,
        dwellingId: Int,
        floorId: Int,
        id: Int,
        apartmentNumber: Int?,
        owner: String?,
        type: String?
    ) {
        apartmentRepository.save(
            findByStreetIdAndDwellingIdAndFloorIdAndId(streetId, dwellingId, floorId, id).run {
                Apartment(
                    id = this.id,
                    number = this.number,
                    owner = owner ?: this.owner,
                    type = if (type != null) ApartmentType.valueOf(type) else null,
                    floor = this.floor,
                    createdAt = this.createdAt,
                    lastModifiedAt = Instant.now(),
                )
            }
        )
    }

    fun delete(streetId: Int, dwellingId: Int, floorId: Int, id: Int) {
        findByStreetIdAndDwellingIdAndFloorIdAndId(streetId, dwellingId, floorId, id).run {
            apartmentRepository.deleteById(this.id ?: id)
        }
    }

}