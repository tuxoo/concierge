package ru.home.concierge.model.enums

enum class Role(
    private val description: String
) {
    ADMIN("Администратор"),
    TENANT("Жилец"),
}