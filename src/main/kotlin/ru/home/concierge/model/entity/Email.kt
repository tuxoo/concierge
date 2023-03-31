package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Getter
@Setter
@Entity
@Table(name = "email")
class Email(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @NotNull
    @Column(name = "address", length = 255, nullable = false)
    val address: String,

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User
)