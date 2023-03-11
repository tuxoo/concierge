package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
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
    val id: Int,

    @Column(name = "number", nullable = false)
    val number: Int,

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "floor")
    val apartments: List<Apartment>,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwelling_id", nullable = false)
    val dwelling: Dwelling,
)