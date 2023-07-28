package com.stackroute.paymentservice.controller;

import com.stackroute.paymentservice.controllers.PaymentRestController;
import com.stackroute.paymentservice.exception.PaymentNotFoundException;
import com.stackroute.paymentservice.service.IPaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentRestControllerTest {

    @InjectMocks
    @Spy
    PaymentRestController controller;

    @Mock
    private IPaymentService service;


    @Test
    void testDeletePayment() throws PaymentNotFoundException {
        int paymentId = 1;
        String response = "Payment Deleted Successfully";
        when(service.deletePayment(paymentId)).thenReturn(response);
        String result = controller.deletePayment(paymentId).getBody();
        assertEquals(response, result);
        verify(service).deletePayment(paymentId);
    }

    @Test
    void testGetAllPayments() throws Exception {
        when(service.getPayments()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/payment/getPayments");
        MockMvcBuilders.standaloneSetup(controller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPaymentsByEmailId() throws Exception {
        when(service.getPaymentsByEmailId((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/payment/getPayments/{userName}", "jhondoe@email.com");
        MockMvcBuilders.standaloneSetup(controller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

}