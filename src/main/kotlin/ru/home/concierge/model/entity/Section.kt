package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Min

@Getter
@Setter
@Entity
@Table(name = "section")
class Section(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "number", nullable = false)
    val number: Int,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dwelling_id", nullable = false)
    val dwelling: Dwelling,

    @OneToMany(mappedBy = "section")
    val floors: List<Floor> = emptyList(),
)