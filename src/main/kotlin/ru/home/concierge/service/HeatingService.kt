package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.dto.HeatingDto
import ru.home.concierge.model.entity.Heating
import ru.home.concierge.model.exception.BusinessLogicException
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.HeatingRepository
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

    fun create(streetId: Int, dwellingId: Int, apartmentId: Int, heatingDto: HeatingDto) {
        val dwelling = dwellingService.findById(streetId, dwellingId)
        val city = dwelling.street.city

        val now = ZonedDateTime.now(ZoneId.of(city.getTimeZone()))
        if (now.dayOfMonth < dwelling.startMeasuringDay || now.dayOfMonth > dwelling.stopMeasuringDay) {
            throw BusinessLogicException("Measuring period [${dwelling.startMeasuringDay} : ${dwelling.stopMeasuringDay}]")
        }

        return apartmentService.findById(streetId, dwellingId, apartmentId)
            .run {
                heatingRepository.save(
                    Heating(
                        measure = heatingDto.measure!!,
                        month = monthService.getById(now.month.value),
                        year = yearService.getById(now.year),
                        lastModifiedAt = Instant.now(),
                        apartment = this,
                    )
                )
            }
    }

    fun getByCurrenPeriod(
        streetId: Int,
        dwellingId: Int,
    ): List<HeatingDto> {
        val dwelling = dwellingService.findById(streetId, dwellingId)
        val city = dwelling.street.city

        val now = ZonedDateTime.now(ZoneId.of(city.getTimeZone()))
        return dwelling.floors.asSequence().map {
            it.apartments
        }.flatten().map {
            it.heating
        }.flatten().filter {
            it.month.id == now.month.value && it.year.id == now.year
        }.map {
            HeatingDto(
                id = it.id,
                measure = it.measure,
                createdAt = it.createdAt,
                lastModifiedAt = it.lastModifiedAt,
            )
        }.toList()
    }

    fun findById(streetId: Int, dwellingId: Int, apartmentId: Int, id: Int): Heating =
        apartmentService.findById(streetId, dwellingId, apartmentId).heating.find {
            it.id == id
        } ?: throw NotFoundException("The Heating not found by id [$id] in apartment [$apartmentId]")

    fun updateById(
        streetId: Int, dwellingId: Int, id: Int, apartmentId: Int, measure: Double?,
    ) {
        heatingRepository.save(
            findById(streetId, dwellingId, apartmentId, id).run {
                Heating(
                    id = this.id,
                    measure = measure ?: this.measure,
                    month = this.month,
                    year = this.year,
                    lastModifiedAt = Instant.now(),
                    apartment = this.apartment,
                )
            }
        )
    }

}