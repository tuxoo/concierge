package ru.home.concierge.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.HeatingDto
import ru.home.concierge.model.dto.HeatingFilter
import ru.home.concierge.model.entity.Heating
import ru.home.concierge.model.exception.BusinessLogicException
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.HeatingRepository
import ru.home.concierge.repository.specification.HeatingSpecification
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class HeatingService(
    private val heatingRepository: HeatingRepository,
    private val dwellingService: DwellingService,
    private val apartmentService: ApartmentService,
    private val monthService: MonthService,
    private val yearService: YearService,
) {

    fun create(dwellingId: Int, apartmentId: Int, heatingDto: HeatingDto) {
        val dwelling = dwellingService.findByIdOrThrow(dwellingId)
        val city = dwelling.street.city

        val now = ZonedDateTime.now(ZoneId.of(city.getTimeZone()))
        if (now.dayOfMonth < dwelling.startMeasuringDay || now.dayOfMonth > dwelling.stopMeasuringDay) {
            throw BusinessLogicException("Measuring period [${dwelling.startMeasuringDay} : ${dwelling.stopMeasuringDay}]")
        }

        return apartmentService.findByDwellingIdAndIdOrThrow(dwellingId, apartmentId)
            .run {
                heatingRepository.save(
                    Heating(
                        measure = heatingDto.measure!!,
                        month = monthService.getById(now.month.value),
                        year = yearService.getById(now.year),
                        lastModifiedAt = Instant.now(),
                        dwelling = dwelling,
                        apartment = this,
                    )
                )
            }
    }

    fun getAll(filter: HeatingFilter, pageable: Pageable): Page<HeatingDto> =
        dwellingService.findByIdOrThrow(filter.dwellingId).run {
            heatingRepository.findAll(HeatingSpecification.byFilter(filter), pageable)
        }.map { HeatingDto.fromEntity(it) }

    fun findById(dwellingId: Int, apartmentId: Int, id: Int): Heating =
        apartmentService.findByDwellingIdAndIdOrThrow(dwellingId, apartmentId).heating.find { it.id == id }
            ?: throw NotFoundException("The Heating not found by id [$id] in apartment [$apartmentId]")

    fun updateById(dwellingId: Int, id: Int, apartmentId: Int, measure: Double?) =
        HeatingDto.fromEntity(heatingRepository.save(
            findById(dwellingId, apartmentId, id).run {
                Heating(
                    id = this.id,
                    measure = measure ?: this.measure,
                    month = this.month,
                    year = this.year,
                    lastModifiedAt = Instant.now(),
                    dwelling = this.dwelling,
                    apartment = this.apartment,
                )
            }
        ))

}