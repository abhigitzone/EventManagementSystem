package com.stackroute.participantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ExceptionHandler(ParticipantNotFoundException.class)
    public String handleNotFound(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(ParticipantAreadyExistException.class)
    public String handleNotFound1(Exception e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({

            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalidArgument(Exception e) {
        return "invalid arguments";
    }
}

