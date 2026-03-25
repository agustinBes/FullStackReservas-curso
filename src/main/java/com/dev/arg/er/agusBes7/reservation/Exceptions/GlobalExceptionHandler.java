package com.dev.arg.er.agusBes7.reservation.Exceptions;

import com.dev.arg.er.agusBes7.reservation.Exceptions.ReservaExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReservaExistException.class)
    public ResponseEntity<String> handleNotFound(ReservaExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}