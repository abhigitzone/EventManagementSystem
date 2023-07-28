package com.stackroute.paymentservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "payment")
public class PaymentModel {

    @Id
    private int paymentId;
    private int participantID;

    private String userEmailID;
    @Min(1)
    private double amount;
    private String status;
    private String razorpayOrderId;

}
