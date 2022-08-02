package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class PlanRefundClient implements RefundClient {
    @Override
    public void processRefund(Transaction transaction) {
        log.info("Processing Plan card refund for amount: " + transaction.getAmount());
    }
}
