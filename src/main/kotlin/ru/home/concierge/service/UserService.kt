package ru.home.concierge.service

import org.springframework.stereotype.Service
import ru.home.concierge.model.entity.User
import ru.home.concierge.model.exception.NotFoundException
import ru.home.concierge.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findByIdOrThrow(id: Int): User = userRepository.findById(id).orElseThrow {
        throw NotFoundException("The user not found by id [$id]")
    }
}