package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class CreditCardRefundClient implements RefundClient {
    @Override
    public void processRefund(Transaction transaction) {
        log.info("Processing credit card refund for amount: " + transaction.getAmount());
    }
}
