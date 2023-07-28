package com.stackroute.paymentservice.service;

import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.PaymentAlreadyExistException;
import com.stackroute.paymentservice.exception.PaymentNotFoundException;
import com.stackroute.paymentservice.model.PaymentModel;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface IPaymentService {

    PaymentModel addPayment(PaymentModel paymentModel) throws RazorpayException, PaymentAlreadyExistException;

    PaymentModel getPaymentByPaymentId(int paymentId) throws PaymentNotFoundException;

    List<PaymentModel> getPayments() throws PaymentNotFoundException;

    String deletePayment(int paymentId) throws PaymentNotFoundException;

    List<PaymentModel> getPaymentsByEmailId(String userEmailId) throws PaymentNotFoundException;
}
