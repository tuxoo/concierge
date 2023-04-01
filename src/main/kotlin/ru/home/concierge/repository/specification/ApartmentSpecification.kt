package ru.home.concierge.repository.specification

import org.springframework.data.jpa.domain.Specification
import ru.home.concierge.model.dto.ApartmentFilter
import ru.home.concierge.model.entity.*

class ApartmentSpecification {

    companion object {

        fun byFilter(filter: ApartmentFilter): Specification<Apartment> =
            Specification
                .where(byDwellingId(filter.dwellingId))
                .and(byFloorId(filter.floorId))
                .and(byNumber(filter.number))
                .and(byOwner(filter.owner))
                .and(byPhone(filter.phone))

        private fun byDwellingId(dwellingId: Int?): Specification<Apartment> {
            return Specification<Apartment> { root, _, builder ->
                if (dwellingId == null) {
                    null
                } else {
                    builder.equal(root.get(Apartment_.dwelling).get<Dwelling>(Dwelling_.ID), dwellingId)
                }
            }
        }

        private fun byFloorId(floorId: Int?): Specification<Apartment> {
            return Specification<Apartment> { root, _, builder ->
                if (floorId == null) {
                    null
                } else {
                    builder.equal(root.get(Apartment_.floor).get<Floor>(Floor_.ID), floorId)
                }
            }
        }

        private fun byNumber(number: Int?): Specification<Apartment> {
            return Specification<Apartment> { root, _, builder ->
                if (number == null) {
                    null
                } else {
                    builder.equal(root.get<Apartment>(Apartment_.NUMBER), number)
                }
            }
        }

        private fun byOwner(owner: String?): Specification<Apartment> {
            return Specification<Apartment> { root, _, builder ->
                if (owner.isNullOrBlank()) {
                    null
                } else {
                    builder.like(builder.lower(root.get(Apartment_.OWNER)), "%${owner.lowercase()}%")
                }
            }
        }

        private fun byPhone(phone: String?): Specification<Apartment> {
            return Specification<Apartment> { root, _, builder ->
                if (phone.isNullOrBlank()) {
                    null
                } else {
                    builder.like(builder.lower(root.get(Apartment_.PHONE)), "%${phone.lowercase()}%")
                }
            }
        }
    }
}