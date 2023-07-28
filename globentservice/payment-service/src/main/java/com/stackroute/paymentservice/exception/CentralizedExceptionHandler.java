package com.stackroute.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public String handleNotFound(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(PaymentAlreadyExistException.class)
    public String handleAlreadyExist(Exception e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            PaymentFailedException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalidArgument(Exception e) {
        return "invalid arguments";
    }
}
