package com.krungsri.workshop.controller;

import com.krungsri.workshop.model.ProcessedTransactionResult;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.repository.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaymentTransactionController {

    final TransactionRepository transactionRepository;

    public PaymentTransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping(value = "/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll().stream()
                .sorted(Comparator.comparing(Transaction::getId, Integer::compareTo))
                .collect(Collectors.toList());
    }

    // TODO: Complete this endpoint
    @PostMapping(value = "/transactions")
    public ProcessedTransactionResult processTransactions(@RequestBody List<Transaction> transactions) {
        return ProcessedTransactionResult.builder()
                .paypal(100.25)
                .creditCard(213.32)
                .plan(387.65)
                .build();
    }
}
