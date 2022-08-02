package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.model.PaymentType;
import com.krungsri.workshop.model.ProcessedTransactionResult;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.model.TransactionStatus;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class TransactionServiceImpl implements TransactionService {
    @Override
    public ProcessedTransactionResult processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionType {
        if (transactions != null && transactions.size() > 0) {
            for (Transaction transaction : transactions) {
                if (transaction.getType() == PaymentType.PAYMENT) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {

                    } else {
                        log.info("Transaction " + transaction.getId() + " was closed");
                    }
                } else if (transaction.getType() == PaymentType.REFUND) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {

                    } else {
                        log.info("Transaction " + transaction.getId() + " was closed");
                    }
                } else {
                    throw new InvalidTransactionType();
                }
            }
        } else {
            throw new NoTransactionProvided();
        }
        return ProcessedTransactionResult.builder().build();
    }
}
