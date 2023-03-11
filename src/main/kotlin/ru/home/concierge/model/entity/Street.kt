package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
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
    val createdAt: Instant = Instant.now(),

    @Column(name = "last_modified_at")
    val lastModifiedAt: Instant = Instant.now(),

    @OneToMany(mappedBy = "street")
    val dwellings: List<Dwelling>? = null,
)