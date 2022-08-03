package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class PaypalRefundProvider implements RefundProvider {
    @Override
    public void process(Transaction transaction) {
        log.info("Processing PayPal Refund for amount: " + transaction.getAmount());
    }
}
