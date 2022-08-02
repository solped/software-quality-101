package com.krungsri.workshop.infrastructure;


import com.krungsri.workshop.model.Transaction;

public interface PaymentProvider {
    void processPayment(Transaction transaction);
}
