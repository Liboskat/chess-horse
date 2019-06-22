package ru.itis.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.models.ExceptionResponse;

import javax.validation.ConstraintViolationException;

/**
 * Обработчик ошибок
 *
 * @author Ilshat Rizvanov
 **/
@ControllerAdvice
public class IllegalArgumentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<ExceptionResponse> handleInvalidParameterExceptions(Exception e) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build(),
                HttpStatus.BAD_REQUEST);
    }
}
