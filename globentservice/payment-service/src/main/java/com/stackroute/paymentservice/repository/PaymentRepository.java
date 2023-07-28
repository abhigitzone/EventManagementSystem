package com.stackroute.paymentservice.repository;

import com.stackroute.paymentservice.model.PaymentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentModel, Integer> {

}
