package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import ru.home.concierge.model.enums.City
import java.time.Instant
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "street")
class Street(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "city", length = 255, nullable = false)
    val city: City,

    @Column(name = "created_at", updatable = false)
    val createdAt: Instant? = null,

    @Column(name = "last_modified_at")
    val lastModifiedAt: Instant,

    @OneToMany(mappedBy = "street")
    val dwellings: List<Dwelling> = emptyList(),
)