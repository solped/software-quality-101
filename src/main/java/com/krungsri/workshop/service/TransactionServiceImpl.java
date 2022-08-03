package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.infrastructure.*;
import com.krungsri.workshop.model.*;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.List;

@Log
@Component
public class TransactionServiceImpl implements TransactionService {

    private final CreditCardPaymentProvider creditCardPaymentClient;
    private final PaypalPaymentProvider paypalPaymentClient;
    private final CryptoPaymentProvider cryptoPaymentClient;

    public TransactionServiceImpl(CreditCardPaymentProvider creditCardPaymentClient,
                                  PaypalPaymentProvider paypalPaymentClient,
                                  CryptoPaymentProvider cryptoPaymentClient) {
        this.creditCardPaymentClient = creditCardPaymentClient;
        this.paypalPaymentClient = paypalPaymentClient;
        this.cryptoPaymentClient = cryptoPaymentClient;
    }

    @Override
    public void processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        if (transactions != null && transactions.size() > 0) {
            for (Transaction transaction : transactions) {
                if (transaction.getType() == PaymentType.PAYMENT) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {
                        if (transaction.getMethod() == PaymentMethod.CREDIT_CARD) {
                            this.creditCardPaymentClient.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.PAYPAL) {
                            this.paypalPaymentClient.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.CRYPTO) {
                            this.cryptoPaymentClient.processPayment(transaction);
                        } else {
                            throw new InvalidTransactionPaymentMethod();
                        }
                    } else {
                        log.info("Transaction " + transaction.getId() + " was closed");
                    }
                } else if (transaction.getType() == PaymentType.REFUND) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {
                        if (transaction.getMethod() == PaymentMethod.CREDIT_CARD) {
                            this.creditCardPaymentClient.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.PAYPAL) {
                            this.paypalPaymentClient.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.CRYPTO) {
                            this.cryptoPaymentClient.processPayment(transaction);
                        } else {
                            throw new InvalidTransactionPaymentMethod();
                        }
                    } else {
                        log.info("Transaction " + transaction.getId() + " was closed");
                    }
                } else {
                    throw new InvalidTransactionPaymentType();
                }
            }
        } else {
            throw new NoTransactionProvided();
        }
    }
}
