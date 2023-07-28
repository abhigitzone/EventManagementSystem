package com.stackroute.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDetails {

    private int paymentId;
    private int participantID;
    private String userEmailID;
    private double amount;
    private String status;
    private String razorpayOrderId;

}
