package ru.home.concierge.service

import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.StreetDto
import ru.home.concierge.model.entity.Street
import ru.home.concierge.model.enums.City
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.StreetRepository
import java.time.Instant

@Service
@CacheConfig(cacheNames = ["street"])
class StreetService(
    private val streetRepository: StreetRepository,
) {

    fun create(streetDto: StreetDto) {
        streetRepository.save(streetDto.toEntity())
    }

    fun getAll(pageable: Pageable): Page<StreetDto> =
        streetRepository.findAll(pageable).map {
            StreetDto(
                id = it.id,
                name = it.name,
                city = it.city.getShortName(),
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        }

    @Cacheable
    fun getById(id: Int): StreetDto =
        findById(id).run {
            StreetDto(
                id = this.id,
                name = this.name,
                city = this.city.getShortName(),
                createdAt = this.createdAt,
                lastModifiedAt = this.lastModifiedAt,
            )
        }

    fun findById(id: Int): Street = streetRepository.findById(id).orElseThrow {
        NotFoundException("The street not found by id [$id]")
    }

    @CachePut(key = "#id")
    fun updateById(id: Int, name: String?, city: String?): StreetDto =
        StreetDto.fromEntity(streetRepository.save(
            findById(id).run {
                Street(
                    id = this.id,
                    name = name ?: this.name,
                    city = if (city != null) City.fromShortName(city) else this.city,
                    lastModifiedAt = Instant.now(),
                )
            }
        ))

    @CacheEvict(key = "#id")
    fun delete(id: Int) = streetRepository.deleteById(id)
}