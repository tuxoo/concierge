package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.repository.DwellingRepository

@Service
class DwellingService(
    private val dwellingRepository: DwellingRepository,
) {
}