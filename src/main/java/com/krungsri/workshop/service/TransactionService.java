package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.model.ProcessedTransactionResult;
import com.krungsri.workshop.model.Transaction;

import java.util.List;

public interface TransactionService {
    ProcessedTransactionResult processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionType;
}
