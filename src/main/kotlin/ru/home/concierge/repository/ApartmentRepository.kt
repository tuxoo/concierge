package ru.home.concierge.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.home.concierge.model.entity.Apartment
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Street

@Repository
interface ApartmentRepository : JpaRepository<Apartment, Int> {
    fun findAllByDwelling(dwelling: Dwelling, pageable: Pageable): Page<Apartment>
}