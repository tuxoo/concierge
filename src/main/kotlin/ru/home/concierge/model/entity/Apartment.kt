package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import ru.home.concierge.model.enums.ApartmentType
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

@Getter
@Setter
@Entity
@Table(name = "apartment")
class Apartment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Min(0)
    @Column(name = "number", nullable = false)
    val number: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true)
    val type: ApartmentType?,

    @NotEmpty
    @Column(name = "owner", length = 255, nullable = true)
    val owner: String?,

    @Column(name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at")
    val lastModifiedAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "apartment")
    val heating: List<Heating>? = null,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    val floor: Floor,
)