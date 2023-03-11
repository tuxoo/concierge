package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.repository.FloorRepository

@Service
class FloorService(
    private val floorRepository: FloorRepository,
) {
}