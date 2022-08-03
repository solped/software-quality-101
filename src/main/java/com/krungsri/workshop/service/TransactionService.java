package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.model.Transaction;

import java.util.List;

public interface TransactionService {
    void processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod;
}
