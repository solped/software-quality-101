package com.krungsri.workshop.controller;

import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.repository.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentTransactionController {

    final TransactionRepository transactionRepository;

    public PaymentTransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping(value = "/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll();
    }
}
