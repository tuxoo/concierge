package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Getter
@Setter
@Entity
@Table(name = "floor")
class Floor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "number", nullable = false)
    val number: Int,

    @Column(name = "section", nullable = false)
    val section: Int,

    @Column(name = "apartment_number", nullable = false)
    val apartmentNumber: Int,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at", nullable = false)
    val lastModifiedAt: Instant,

    @OneToMany(mappedBy = "floor")
    val apartments: List<Apartment> = emptyList(),

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwelling_id", nullable = false)
    val dwelling: Dwelling,
)