package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Getter
@Setter
@Entity
@Table(name = "year")
class Year(

    @Id
    val id: Int,
)