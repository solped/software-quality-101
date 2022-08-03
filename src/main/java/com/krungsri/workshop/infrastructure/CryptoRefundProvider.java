package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class CryptoRefundProvider implements RefundProvider {
    @Override
    public void processRefund(Transaction transaction) {
        log.info("Processing Crypto Refund for amount: " + transaction.getAmount());
    }
}
