package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.entity.Month
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.MonthRepository

@Service
class MonthService(
    private val monthRepository: MonthRepository,
) {

    fun getAll(): List<Month> = monthRepository.findAll()

    fun getById(id: Int): Month = monthRepository.findById(id).orElseThrow {
        throw NotFoundException("The month not found by id [$id]")
    }
}