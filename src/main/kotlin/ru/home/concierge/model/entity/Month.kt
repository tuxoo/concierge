package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

@Getter
@Setter
@Entity
@Table(name = "month")
class Month(

    @Id
    val id: Int,

    @NotEmpty
    @Column(name = "name", length = 15, nullable = false)
    val name: String,
)