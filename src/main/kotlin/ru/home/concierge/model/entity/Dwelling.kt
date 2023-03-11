package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

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

    @Column(name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at")
    val lastModifiedAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "dwelling")
    val floors: List<Floor>? = null,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    val street: Street
)