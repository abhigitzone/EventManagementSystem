package com.stackroute.paymentservice.controllers;

import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.PaymentAlreadyExistException;
import com.stackroute.paymentservice.exception.PaymentNotFoundException;
import com.stackroute.paymentservice.model.PaymentModel;
import com.stackroute.paymentservice.producer.MQConfigPayment;
import com.stackroute.paymentservice.service.IPaymentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/payment")
@RestController
public class PaymentRestController {

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/pay")
    public ResponseEntity<PaymentModel> makePayment(@RequestBody PaymentModel paymentModel) throws RazorpayException, PaymentAlreadyExistException {
        PaymentModel response = paymentService.addPayment(paymentModel);
        template.convertAndSend(MQConfigPayment.EXCHANGE,
                MQConfigPayment.ROUTING_KEY, response);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/deletePayment/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable int paymentId) throws PaymentNotFoundException {
        return new ResponseEntity<>(paymentService.deletePayment(paymentId), HttpStatus.OK);

    }

    @GetMapping("/getPayments")
    public ResponseEntity<List<PaymentModel>> getAllPayments() throws PaymentNotFoundException {
        return new ResponseEntity<>(paymentService.getPayments(), HttpStatus.OK);
    }

    // Change it to participants id.
    @GetMapping("/getPayment/{paymentId}")
    public ResponseEntity<Object> getPaymentByPaymentId(@PathVariable int paymentId) throws PaymentNotFoundException {
        return new ResponseEntity<>(paymentService.getPaymentByPaymentId(paymentId), HttpStatus.OK);

    }

    @GetMapping("/getPayments/{userName}")
    public ResponseEntity<Object> getPaymentByUserEmailId(@PathVariable String userName) throws PaymentNotFoundException {
        return new ResponseEntity<>(paymentService.getPaymentsByEmailId(userName), HttpStatus.OK);
    }
}
