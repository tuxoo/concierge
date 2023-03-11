package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "dwelling")
    val floors: List<Floor>? = null,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    val street: Street
)