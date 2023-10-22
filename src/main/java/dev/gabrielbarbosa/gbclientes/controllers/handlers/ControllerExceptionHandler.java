package dev.gabrielbarbosa.gbclientes.controllers.handlers;

import dev.gabrielbarbosa.gbclientes.dto.CustomError;
import dev.gabrielbarbosa.gbclientes.dto.ValidationError;
import dev.gabrielbarbosa.gbclientes.services.exceptions.NotFoundClientException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundClientException.class)
    public ResponseEntity<CustomError> notFoundClient(NotFoundClientException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        e.getBindingResult().getFieldErrors()
                .forEach(fieldError -> err.addError(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.status(status).body(err);
    }

}
