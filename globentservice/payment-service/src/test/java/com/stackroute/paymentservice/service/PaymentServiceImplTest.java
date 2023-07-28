package com.stackroute.paymentservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.PaymentAlreadyExistException;
import com.stackroute.paymentservice.exception.PaymentNotFoundException;
import com.stackroute.paymentservice.model.PaymentModel;
import com.stackroute.paymentservice.repository.PaymentRepository;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PaymentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PaymentServiceImplTest {
    @MockBean
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentServiceImpl paymentServiceImpl;

    @MockBean
    private RazorPayOrderServices razorPayOrderServices;

    @Test
    void testAddPayment() throws RazorpayException, PaymentAlreadyExistException {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setAmount(1000.0d);
        paymentModel.setParticipantID(1);
        paymentModel.setPaymentId(10);
        paymentModel.setRazorpayOrderId("order_KwbICfRuxpNzNL");
        paymentModel.setStatus("Created");
        paymentModel.setUserEmailID("abhishek.raj3@globallogic.com");
        when(paymentRepository.existsById((Integer) any())).thenReturn(true);
        when(paymentRepository.save((PaymentModel) any())).thenReturn(paymentModel);

        PaymentModel paymentModel1 = new PaymentModel();
        paymentModel1.setAmount(1000.0d);
        paymentModel1.setParticipantID(1);
        paymentModel1.setPaymentId(10);
        paymentModel1.setRazorpayOrderId("order_KwbICfRuxpNzNL");
        paymentModel1.setStatus("Created");
        paymentModel1.setUserEmailID("abhishek.raj3@globallogic.com");
        assertThrows(PaymentAlreadyExistException.class, () -> paymentServiceImpl.addPayment(paymentModel1));
        verify(paymentRepository).existsById((Integer) any());
    }

    @Test
    void testGetPaymentByPaymentId() throws PaymentNotFoundException {
        when(paymentRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(PaymentNotFoundException.class, () -> paymentServiceImpl.getPaymentByPaymentId(123));
        verify(paymentRepository).findById((Integer) any());
    }

    @Test
    void testGetPayments() throws PaymentNotFoundException {
        when(paymentRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(PaymentNotFoundException.class, () -> paymentServiceImpl.getPayments());
        verify(paymentRepository).findAll();
    }

    @Test
    void testDeletePayment() throws PaymentNotFoundException {
        doNothing().when(paymentRepository).deleteById((Integer) any());
        when(paymentRepository.existsById((Integer) any())).thenReturn(true);
        assertEquals("Payment Deleted Successfully", paymentServiceImpl.deletePayment(123));
        verify(paymentRepository).existsById((Integer) any());
        verify(paymentRepository).deleteById((Integer) any());
    }

    @Test
    void testGetPaymentsByEmailId() throws PaymentNotFoundException {
        when(paymentRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(PaymentNotFoundException.class, () -> paymentServiceImpl.getPaymentsByEmailId("abhishek.raj3@globallogic.com"));
        verify(paymentRepository).findAll();
    }

}

