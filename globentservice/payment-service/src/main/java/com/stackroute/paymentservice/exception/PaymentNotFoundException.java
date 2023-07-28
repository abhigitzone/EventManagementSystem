package com.stackroute.paymentservice.exception;

public class PaymentNotFoundException extends Exception {
    public PaymentNotFoundException(String msg) {
        super(msg);
    }
}
