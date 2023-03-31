package ru.home.concierge.config.advice

import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import ru.home.concierge.model.error.ErrorResponse
import ru.home.concierge.model.error.ValidationError
import ru.home.concierge.model.error.ValidationErrorResponse
import ru.home.concierge.model.exception.BusinessLogicException
import ru.home.concierge.model.exception.NotFoundException
import java.time.Instant
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(BusinessLogicException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBusinessLogicException(e: BusinessLogicException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse(
                message = e.message ?: "Business logic error",
                errorTime = Instant.now(),
            )
        )
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                message = e.message ?: "Entity not found",
                errorTime = Instant.now(),
            )
        )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintValidationException(e: ConstraintViolationException): ResponseEntity<ValidationErrorResponse> {
        val validationErrors = ArrayList<ValidationError>()

        e.constraintViolations.iterator().forEach { constraint ->
            var field = ""
            constraint.propertyPath.forEach { path ->
                field = path.name
            }
            validationErrors.add(ValidationError(field, constraint.message ?: ""))
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ValidationErrorResponse(
                message = "Incorrect request parameters",
                validationErrors = validationErrors,
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleArgumentValidationException(e: MethodArgumentNotValidException): ResponseEntity<ValidationErrorResponse> {
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