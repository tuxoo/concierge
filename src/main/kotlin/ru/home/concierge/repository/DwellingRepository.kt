package ru.home.concierge.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.home.concierge.model.entity.Dwelling

@Repository
interface DwellingRepository : JpaRepository<Dwelling, Int> {
}