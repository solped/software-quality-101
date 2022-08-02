package com.krungsri.workshop.infrastructure;


import com.krungsri.workshop.model.Transaction;

public interface PaymentClient {
    void processPayment(Transaction transaction);
}
