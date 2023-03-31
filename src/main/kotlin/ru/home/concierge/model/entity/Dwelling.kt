package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Getter
@Setter
@Entity
@Table(name = "dwelling")
class Dwelling(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @NotEmpty
    @Column(name = "number", length = 15, nullable = false, updatable = false)
    val number: String,

    @Min(1)
    @Column(name = "floor_number", nullable = false)
    val floorNumber: Int,

    @Min(1)
    @Column(name = "section_number", nullable = false)
    val sectionNumber: Int,

    @Min(1)
    @Max(31)
    @NotNull
    @Column(name = "start_measuring_day", nullable = false)
    val startMeasuringDay: Int,

    @Min(1)
    @Max(31)
    @NotNull
    @Column(name = "stop_measuring_day", nullable = false)
    val stopMeasuringDay: Int,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at", nullable = false)
    val lastModifiedAt: Instant,

    @OneToMany(mappedBy = "dwelling")
    val floors: List<Floor> = emptyList(),

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    val street: Street
)