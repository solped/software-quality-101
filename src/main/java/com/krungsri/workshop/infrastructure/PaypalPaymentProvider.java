package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class PaypalPaymentProvider implements PaymentProvider {
    @Override
    public void processPayment(Transaction transaction) {
        log.info("Processing Paypal " + transaction.getType().toString() + " for amount: " + transaction.getAmount());
    }
}
