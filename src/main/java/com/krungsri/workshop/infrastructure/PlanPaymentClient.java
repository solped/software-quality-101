package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class PlanPaymentClient implements PaymentClient {
    @Override
    public void processPayment(Transaction transaction) {
        log.info("Processing Plan payment for amount: " + transaction.getAmount());
    }
}
