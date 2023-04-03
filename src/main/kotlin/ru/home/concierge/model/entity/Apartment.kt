package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import ru.home.concierge.model.enums.ApartmentType
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Min

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

    @Column(name = "owner", length = 255, nullable = true)
    val owner: String? = null,

    @Column(name = "phone", length = 15, nullable = true)
    val phone: String? = null,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant? = null,

    @Column(name = "last_modified_at", nullable = false)
    val lastModifiedAt: Instant,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwelling_id", nullable = false)
    val dwelling: Dwelling,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    val floor: Floor,

    @OneToMany(mappedBy = "apartment")
    val heating: List<Heating> = emptyList(),
)