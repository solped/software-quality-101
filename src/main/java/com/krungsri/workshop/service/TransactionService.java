package com.krungsri.workshop.service;

import com.krungsri.workshop.model.Transaction;

import java.util.List;

public interface TransactionService {
    void processTransaction(List<Transaction> transactions);
}
