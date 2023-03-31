package ru.home.concierge.model.enums

import lombok.Getter


@Getter
enum class Auth(
    val value: String,
    val length: Int,
) {
    AUTHORIZATION("Authorization", 13),
    BEARER("Bearer ", 7),
    BASIC("Basic ", 6),
    JWT("JWT", 3);
}
