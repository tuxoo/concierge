package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.repository.EmailRepository

@Service
class EmailService(
    private val emailRepository: EmailRepository,
) {

    fun getAll(): List<String> = emailRepository.findAll().map {
        it.address
    }

    fun getByUser(userId: Int): List<String> = emailRepository.findAllByUserId(userId).map {
        it.address
    }
}