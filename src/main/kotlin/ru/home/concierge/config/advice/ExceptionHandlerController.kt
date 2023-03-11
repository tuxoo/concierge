package ru.home.concierge.config.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import ru.home.concierge.model.error.ValidationError
import ru.home.concierge.model.error.ValidationErrorResponse

@ControllerAdvice
class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<ValidationErrorResponse> {
        val validationErrors = e.bindingResult.fieldErrors.map {
            ValidationError(it.field, it.defaultMessage ?: "")
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ValidationErrorResponse(
                validationErrors = validationErrors,
            )
        )
    }
}