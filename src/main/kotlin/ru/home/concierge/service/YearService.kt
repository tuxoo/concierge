package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.entity.Year
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.YearRepository

@Service
class YearService(
    private val yearRepository: YearRepository,
) {

    fun getAll(): List<Year> = yearRepository.findAll()

    fun getById(id: Int): Year = yearRepository.findById(id).orElseThrow {
        throw NotFoundException("The year not found by id [$id]")
    }
}