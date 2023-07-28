package com.stackroute.paymentservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentModelTest {

    PaymentModel model = new PaymentModel();

    @Test
    void testGetPaymentId() {
        model.setPaymentId(1);
        assertEquals(1, model.getPaymentId());
    }

    @Test
    void testGetParticipantID() {
        model.setParticipantID(1);
        assertEquals(1, model.getParticipantID());
    }

    @Test
    void testGetUserEmailId() {
        model.setUserEmailID("abhishek.raj3@globallogic.com");
        assertEquals("abhishek.raj3@globallogic.com", model.getUserEmailID());
    }

    @Test
    void testGetAmount() {
        model.setAmount(1000);
        assertEquals(1000, model.getAmount());
    }

    @Test
    void testGetStatus() {
        model.setStatus("Created");
        assertEquals("Created", model.getStatus());
    }

    @Test
    void testGetRazorpayOrderId() {
        model.setRazorpayOrderId("order_KwbICfRuxpNzNL");
        assertEquals("order_KwbICfRuxpNzNL", model.getRazorpayOrderId());
    }

}
