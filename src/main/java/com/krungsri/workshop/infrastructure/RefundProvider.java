package com.krungsri.workshop.infrastructure;


import com.krungsri.workshop.model.Transaction;

public interface RefundProvider {
    void processRefund(Transaction transaction);
}
