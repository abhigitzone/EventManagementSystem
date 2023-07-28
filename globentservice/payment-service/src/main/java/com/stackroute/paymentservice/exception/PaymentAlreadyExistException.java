package com.stackroute.paymentservice.exception;

public class PaymentAlreadyExistException extends Exception {

    public PaymentAlreadyExistException(String msg) {
        super(msg);
    }
}
