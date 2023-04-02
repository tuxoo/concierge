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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    val street: Street,

    @OneToMany(mappedBy = "dwelling")
    val sections: List<Section> = emptyList(),

    @OneToMany(mappedBy = "dwelling")
    val apartments: List<Apartment> = emptyList(),

    @OneToMany(mappedBy = "dwelling")
    val heating: List<Heating> = emptyList(),
)