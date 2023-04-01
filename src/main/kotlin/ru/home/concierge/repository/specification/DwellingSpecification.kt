package ru.home.concierge.repository.specification

import org.springframework.data.jpa.domain.Specification
import ru.home.concierge.model.dto.DwellingFilter
import ru.home.concierge.model.entity.Dwelling
import ru.home.concierge.model.entity.Dwelling_
import ru.home.concierge.model.entity.Street
import ru.home.concierge.model.entity.Street_

class DwellingSpecification {

    companion object {

        fun byFilter(filter: DwellingFilter): Specification<Dwelling> =
            Specification
                .where(byStreetId(filter.streetId))
                .and(byNumber(filter.number))

        private fun byStreetId(streetId: Int?): Specification<Dwelling> {
            return Specification<Dwelling> { root, _, builder ->
                if (streetId == null) {
                    null
                } else {
                    builder.equal(root.get(Dwelling_.street).get<Street>(Street_.ID), streetId)
                }
            }
        }

        private fun byNumber(number: String?): Specification<Dwelling> {
            return Specification<Dwelling> { root, _, builder ->
                if (number.isNullOrBlank()) {
                    null
                } else {
                    builder.like(builder.lower(root.get(Dwelling_.NUMBER)), "%${number.lowercase()}%")
                }
            }
        }
    }
}