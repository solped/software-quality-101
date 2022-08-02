package com.krungsri.workshop.repository;

import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.util.TransactionGenerator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    @Override
    public List<Transaction> getAll() {
        return TransactionGenerator.generate(10);
    }
}
