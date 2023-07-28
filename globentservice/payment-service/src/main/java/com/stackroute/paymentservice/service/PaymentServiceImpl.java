package com.stackroute.paymentservice.service;

import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.PaymentAlreadyExistException;
import com.stackroute.paymentservice.exception.PaymentNotFoundException;
import com.stackroute.paymentservice.model.PaymentModel;
import com.stackroute.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final RazorPayOrderServices razorPayOrderServices;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, RazorPayOrderServices razorPayOrderServices) {
        this.paymentRepository = paymentRepository;
        this.razorPayOrderServices = razorPayOrderServices;
    }

    @Transactional
    @Override
    public PaymentModel addPayment(PaymentModel paymentModel) throws RazorpayException, PaymentAlreadyExistException {
        if (!paymentRepository.existsById(paymentModel.getPaymentId())) {
            String razorOrderId = razorPayOrderServices.razorPayOrder(paymentModel);
            paymentModel.setRazorpayOrderId(razorOrderId);
            paymentModel = paymentRepository.save(paymentModel);
        } else {
            throw new PaymentAlreadyExistException("Payment Already Exist with id: " + paymentModel.getPaymentId());
        }
        return paymentModel;
    }

    @Transactional
    @Override
    public PaymentModel getPaymentByPaymentId(int paymentId) throws PaymentNotFoundException {
        if (paymentRepository.findById(paymentId).isPresent()) {
            return paymentRepository.findById(paymentId).get();
        } else {
            throw new PaymentNotFoundException("Payment Not Available");
        }
    }

    @Transactional
    @Override
    public List<PaymentModel> getPayments() throws PaymentNotFoundException {
        if (paymentRepository.findAll().isEmpty()) {
            throw new PaymentNotFoundException("No Payment Available");
        } else {
            return paymentRepository.findAll();
        }
    }


    @Transactional
    @Override
    public String deletePayment(int paymentId) throws PaymentNotFoundException {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
        } else {
            throw new PaymentNotFoundException("Payment Not Available");
        }
        return "Payment Deleted Successfully";
    }

    @Transactional
    @Override
    public List<PaymentModel> getPaymentsByEmailId(String userEmailId) throws PaymentNotFoundException {
        List<PaymentModel> allPayments = this.paymentRepository.findAll();
        List<PaymentModel> userPayments = new ArrayList<>();

        for (PaymentModel pm : allPayments) {
            try {
                if (pm.getUserEmailID().equals(userEmailId)) {
                    userPayments.add(pm);
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
        if (userPayments.isEmpty()) {
            throw new PaymentNotFoundException("Payment is not available for given username");
        }
        return userPayments;
    }
}
