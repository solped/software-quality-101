package com.krungsri.workshop.repository;

import com.krungsri.workshop.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    final List<Transaction> transactions;

    public TransactionRepositoryImpl(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public List<Transaction> getAll() {
        return this.transactions;
    }

    @Override
    public void save(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }
}
