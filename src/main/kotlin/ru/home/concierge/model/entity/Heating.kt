package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Getter
@Setter
@Entity
@Table(name = "heating")
class Heating(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "measure", nullable = false)
    val measure: Double,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at", nullable = false)
    val lastModifiedAt: Instant,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id", nullable = false)
    val month: Month,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_id", nullable = false)
    val year: Year,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    val apartment: Apartment,
)