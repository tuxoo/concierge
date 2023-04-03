package ru.home.concierge.model.entity

import lombok.Getter
import lombok.Setter
import java.time.Instant
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Getter
@Setter
@Entity
@Table(name = "file")
class File(

    @Id
    val id: UUID? = null,

    @Column(name = "size", nullable = false)
    val size: Long,

    @Column(name = "bucket", nullable = false)
    val bucket: String,

    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant? = null,
)