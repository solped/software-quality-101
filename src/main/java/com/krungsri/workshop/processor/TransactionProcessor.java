package com.krungsri.workshop.processor;

import com.krungsri.workshop.model.Transaction;

import java.util.List;

public interface TransactionProcessor {
    void processTransactions(List<Transaction> transactions);
}
