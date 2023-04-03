package ru.home.concierge.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Heating

@Repository
interface HeatingRepository : JpaRepository<Heating, Int>, JpaSpecificationExecutor<Heating> {

    fun findAllByDwelling(dwelling: Dwelling, pageable: Pageable): Page<Heating>
}