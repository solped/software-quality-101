package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.factory.TransactionProcessorAbstractFactory;
import com.krungsri.workshop.model.*;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Component
public class TransactionServiceImpl implements TransactionService {

    private final TransactionProcessorAbstractFactory transactionProcessorFactory;

    public TransactionServiceImpl(TransactionProcessorAbstractFactory transactionProcessorFactory) {
        this.transactionProcessorFactory = transactionProcessorFactory;
    }

    @Override
    public void processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        if (!isValidTransactions(transactions)) {
            throw new NoTransactionProvided();
        }
        List<Transaction> openedTransactions = filterOpenTransactions(transactions);
        for (Transaction transaction : openedTransactions) {
            processTransaction(transaction);
        }
    }

    private void processTransaction(Transaction transaction) throws InvalidTransactionPaymentMethod, InvalidTransactionPaymentType {
        transactionProcessorFactory
                .getProviderFactory(transaction.getType())
                .getProcessor(transaction.getMethod())
                .process(transaction);
    }

    private boolean isValidTransactions(List<Transaction> transactions) {
        return transactions != null && !transactions.isEmpty();
    }

    private List<Transaction> filterOpenTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.OPEN)
                .collect(Collectors.toList());
    }
}
