package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class PaypalPaymentProvider implements PaymentProvider {
    @Override
    public void process(Transaction transaction) {
        log.info("Processing Paypal Payment for amount: " + transaction.getAmount());
    }
}
