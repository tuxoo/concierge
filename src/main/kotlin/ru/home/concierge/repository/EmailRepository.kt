package ru.home.concierge.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.home.concierge.model.entity.Email

@Repository
interface EmailRepository : JpaRepository<Email, Int> {

    fun findAllByUserId(userId: Int): List<Email>
}