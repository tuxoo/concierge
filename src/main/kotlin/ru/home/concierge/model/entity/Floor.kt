package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*

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

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    val section: Section,

    @OneToMany(mappedBy = "floor")
    val apartments: List<Apartment> = emptyList(),
)