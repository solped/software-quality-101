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

    private final CreditCardPaymentProvider creditCardPaymentProvider;
    private final PaypalPaymentProvider paypalPaymentProvider;
    private final CryptoPaymentProvider cryptoPaymentProvider;
    private final CreditCardRefundProvider creditCardRefundProvider;
    private final PaypalRefundProvider paypalRefundProvider;
    private final CryptoRefundProvider cryptoRefundProvider;


    public TransactionServiceImpl(CreditCardPaymentProvider creditCardPaymentProvider,
                                  PaypalPaymentProvider paypalPaymentProvider,
                                  CryptoPaymentProvider cryptoPaymentProvider,
                                  CreditCardRefundProvider creditCardRefundProvider,
                                  PaypalRefundProvider paypalRefundProvider,
                                  CryptoRefundProvider cryptoRefundProvider) {
        this.creditCardPaymentProvider = creditCardPaymentProvider;
        this.paypalPaymentProvider = paypalPaymentProvider;
        this.cryptoPaymentProvider = cryptoPaymentProvider;
        this.creditCardRefundProvider = creditCardRefundProvider;
        this.paypalRefundProvider = paypalRefundProvider;
        this.cryptoRefundProvider = cryptoRefundProvider;
    }

    @Override
    public void processTransaction(List<Transaction> transactions) throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        if (transactions != null && transactions.size() > 0) {
            for (Transaction transaction : transactions) {
                if (transaction.getType() == PaymentType.PAYMENT) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {
                        if (transaction.getMethod() == PaymentMethod.CREDIT_CARD) {
                            this.creditCardPaymentProvider.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.PAYPAL) {
                            this.paypalPaymentProvider.processPayment(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.CRYPTO) {
                            this.cryptoPaymentProvider.processPayment(transaction);
                        } else {
                            throw new InvalidTransactionPaymentMethod();
                        }
                    } else {
                        log.info("Transaction " + transaction.getId() + " was closed");
                    }
                } else if (transaction.getType() == PaymentType.REFUND) {
                    if (transaction.getStatus() == TransactionStatus.OPEN) {
                        if (transaction.getMethod() == PaymentMethod.CREDIT_CARD) {
                            this.creditCardRefundProvider.processRefund(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.PAYPAL) {
                            this.paypalRefundProvider.processRefund(transaction);
                        } else if (transaction.getMethod() == PaymentMethod.CRYPTO) {
                            this.cryptoRefundProvider.processRefund(transaction);
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
