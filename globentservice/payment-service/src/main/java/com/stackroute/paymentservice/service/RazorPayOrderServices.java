package com.stackroute.paymentservice.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.model.PaymentModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorPayOrderServices {

    @Value("${rzp_key_id}")
    private String rzp_key;

    @Value("${rzp_key_secret}")
    private String rzp_secret;


    public String razorPayOrder(PaymentModel paymentModel) throws RazorpayException {
        double amount = paymentModel.getAmount() * 100;

        RazorpayClient razorpay = new RazorpayClient(rzp_key, rzp_secret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");

        String receiptId = String.valueOf(paymentModel.getPaymentId());
        String finalReceipt = "txn_" + receiptId;
        orderRequest.put("receipt", finalReceipt);

        Order order = razorpay.orders.create(orderRequest);
        paymentModel.setStatus(order.get("status"));

        return order.get("id");
    }

}
