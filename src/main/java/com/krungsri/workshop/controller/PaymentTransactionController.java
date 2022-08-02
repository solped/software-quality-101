package com.krungsri.workshop.controller;

import com.krungsri.workshop.exception.InvalidPaymentMethod;
import com.krungsri.workshop.exception.InvalidTransactionType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.repository.TransactionRepository;
import com.krungsri.workshop.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaymentTransactionController {

    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    public PaymentTransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll().stream()
                .sorted(Comparator.comparing(Transaction::getId, Integer::compareTo))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/transactions")
    public ResponseEntity<Object> processTransactions(@RequestBody List<Transaction> transactions) throws NoTransactionProvided, InvalidPaymentMethod, InvalidTransactionType {
        // TODO: Complete this processTransaction
        transactionService.processTransaction(transactions);
        return ResponseEntity.ok().build();
    }
}
