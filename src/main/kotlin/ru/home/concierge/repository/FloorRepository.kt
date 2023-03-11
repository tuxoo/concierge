package ru.home.concierge.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Floor

@Repository
interface FloorRepository : JpaRepository<Floor, Int> {
    fun findAllByDwelling(dwelling: Dwelling): List<Floor>
}