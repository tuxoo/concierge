package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.repository.HeatingRepository

@Service
class HeatingService(
    private val heatingRepository: HeatingRepository
) {
}