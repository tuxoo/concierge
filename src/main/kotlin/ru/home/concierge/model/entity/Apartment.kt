package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
import ru.home.concierge.model.enums.ApartmentType
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

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
    @Column(name = "type", nullable = false)
    val type: ApartmentType,

    @NotEmpty
    @Column(name = "owner", length = 255, nullable = false)
    val owner: String,

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "apartment")
    val heating: List<Heating>,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    val floor: Floor,
)