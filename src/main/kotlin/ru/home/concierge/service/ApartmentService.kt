package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.repository.ApartmentRepository

@Service
class ApartmentService(
    apartmentRepository: ApartmentRepository,
) {
}