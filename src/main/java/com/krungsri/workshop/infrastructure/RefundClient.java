package com.krungsri.workshop.infrastructure;

import com.krungsri.workshop.model.Transaction;

public interface RefundClient {
    void processRefund(Transaction transaction);
}
