package ru.home.concierge.repository.specification

import org.springframework.data.jpa.domain.Specification
import ru.home.concierge.model.dto.HeatingFilter
import ru.home.concierge.model.entity.*

class HeatingSpecification {

    companion object {

        fun byFilter(filter: HeatingFilter): Specification<Heating> =
            Specification
                .where(byDwellingId(filter.dwellingId))
                .and(byApartmentId(filter.apartmentId))
                .and(byYear(filter.year))
                .and(byMonth(filter.month))

        private fun byDwellingId(dwellingId: Int?): Specification<Heating> {
            return Specification<Heating> { root, _, builder ->
                if (dwellingId == null) {
                    null
                } else {
                    builder.equal(root.get(Heating_.dwelling).get<Dwelling>(Dwelling_.ID), dwellingId)
                }
            }
        }

        private fun byApartmentId(apartmentId: Int?): Specification<Heating> {
            return Specification<Heating> { root, _, builder ->
                if (apartmentId == null) {
                    null
                } else {
                    builder.equal(root.get(Heating_.apartment).get<Apartment>(Apartment_.ID), apartmentId)
                }
            }
        }

        private fun byYear(year: Int?): Specification<Heating> {
            return Specification<Heating> { root, _, builder ->
                if (year == null) {
                    null
                } else {
                    builder.equal(root.get(Heating_.year).get<Year>(Year_.ID), year)
                }
            }
        }

        private fun byMonth(month: Int?): Specification<Heating> {
            return Specification<Heating> { root, _, builder ->
                if (month == null) {
                    null
                } else {
                    builder.equal(root.get(Heating_.month).get<Month>(Month_.ID), month)
                }
            }
        }
    }
}