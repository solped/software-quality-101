package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class CryptoPaymentProvider implements PaymentProvider {
    @Override
    public void process(Transaction transaction) {
        log.info("Processing Crypto" + transaction.getType().toString() + " for amount: " + transaction.getAmount());
    }
}
