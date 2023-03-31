package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import ru.home.concierge.model.enums.Role
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotNull

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
class User(

    @Id
    val id: Int,

    @NotNull
    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @NotNull
    @Column(name = "login", length = 255, unique = true, nullable = false)
    val login: String,

    @NotNull
    @Column(name = "password_hash", length = 255, nullable = false)
    val passwordHash: String,

    @Column(name = "registered_at", updatable = false)
    val registeredAt: Instant = Instant.now(),

    @Column(name = "visited_at")
    val visitedAt: Instant,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 255, nullable = false)
    val role: Role,

    @OneToMany(mappedBy = "user")
    val emails: List<Email> = emptyList(),
)