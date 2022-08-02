package com.krungsri.workshop.repository;

import com.krungsri.workshop.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> getAll();

    void save(List<Transaction> transactions);
}
