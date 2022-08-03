package com.krungsri.workshop.service;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.exception.NoTransactionProvided;
import com.krungsri.workshop.infrastructure.CreditCardPaymentProvider;
import com.krungsri.workshop.infrastructure.CryptoPaymentProvider;
import com.krungsri.workshop.infrastructure.PaypalPaymentProvider;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.model.PaymentType;
import com.krungsri.workshop.model.Transaction;
import com.krungsri.workshop.model.TransactionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    @Test
    void givenValidTransaction_whenProcessTransaction_thenProcessPaymentCorrectly() throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction paypalPaymentTransaction = Transaction.builder()
                .id(1)
                .status(TransactionStatus.OPEN)
                .type(PaymentType.PAYMENT)
                .method(PaymentMethod.PAYPAL)
                .amount(100.00)
                .build();
        Transaction paypalRefundTransaction = Transaction.builder()
                .id(1)
                .status(TransactionStatus.OPEN)
                .type(PaymentType.REFUND)
                .method(PaymentMethod.PAYPAL)
                .amount(200.00)
                .build();

        transactions.add(paypalPaymentTransaction);
        transactions.add(paypalRefundTransaction);

        CreditCardPaymentProvider creditCardPaymentProvider = spy(new CreditCardPaymentProvider());
        PaypalPaymentProvider paypalPaymentProvider = spy(new PaypalPaymentProvider());
        CryptoPaymentProvider cryptoPaymentProvider = spy(new CryptoPaymentProvider());
        TransactionServiceImpl transactionService = new TransactionServiceImpl(
                creditCardPaymentProvider,
                paypalPaymentProvider,
                cryptoPaymentProvider
        );

        // when
        transactionService.processTransaction(transactions);

        // then
        verify(paypalPaymentProvider, times(1)).processPayment(paypalPaymentTransaction);
        verify(paypalPaymentProvider, times(1)).processPayment(paypalRefundTransaction);
    }

    @Test
    void givenEmptyTransactions_whenProcessTransaction_thenThrowNoTransactionProvided() throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        // given
        ArrayList<Transaction> emptyTransactions = new ArrayList<>();

        CreditCardPaymentProvider creditCardPaymentProvider = spy(new CreditCardPaymentProvider());
        PaypalPaymentProvider paypalPaymentProvider = spy(new PaypalPaymentProvider());
        CryptoPaymentProvider cryptoPaymentProvider = spy(new CryptoPaymentProvider());
        TransactionServiceImpl transactionService = new TransactionServiceImpl(
                creditCardPaymentProvider,
                paypalPaymentProvider,
                cryptoPaymentProvider
        );

        // when & then
        Assertions.assertThrows(NoTransactionProvided.class,
                () -> transactionService.processTransaction(emptyTransactions));
    }

    @Test
    void givenInvalidPaymentTypeTransactions_whenProcessTransaction_thenThrowInvalidTransactionPaymentType() throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction paypalRefundTransaction = Transaction.builder()
                .id(1)
                .status(TransactionStatus.OPEN)
                .type(PaymentType.INVALID)
                .method(PaymentMethod.PAYPAL)
                .amount(200.00)
                .build();
        transactions.add(paypalRefundTransaction);

        CreditCardPaymentProvider creditCardPaymentProvider = spy(new CreditCardPaymentProvider());
        PaypalPaymentProvider paypalPaymentProvider = spy(new PaypalPaymentProvider());
        CryptoPaymentProvider cryptoPaymentProvider = spy(new CryptoPaymentProvider());
        TransactionServiceImpl transactionService = new TransactionServiceImpl(
                creditCardPaymentProvider,
                paypalPaymentProvider,
                cryptoPaymentProvider
        );

        // when & then
        Assertions.assertThrows(InvalidTransactionPaymentType.class,
                () -> transactionService.processTransaction(transactions));
    }

    @Test
    void givenInvalidPaymentMethodTransactions_whenProcessTransaction_thenThrowInvalidTransactionPaymentMethod() throws NoTransactionProvided, InvalidTransactionPaymentType, InvalidTransactionPaymentMethod {
        // given
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction paypalRefundTransaction = Transaction.builder()
                .id(1)
                .status(TransactionStatus.OPEN)
                .type(PaymentType.PAYMENT)
                .method(PaymentMethod.NOT_SUPPORT)
                .amount(200.00)
                .build();
        transactions.add(paypalRefundTransaction);

        CreditCardPaymentProvider creditCardPaymentProvider = spy(new CreditCardPaymentProvider());
        PaypalPaymentProvider paypalPaymentProvider = spy(new PaypalPaymentProvider());
        CryptoPaymentProvider cryptoPaymentProvider = spy(new CryptoPaymentProvider());
        TransactionServiceImpl transactionService = new TransactionServiceImpl(
                creditCardPaymentProvider,
                paypalPaymentProvider,
                cryptoPaymentProvider
        );

        // when & then
        Assertions.assertThrows(InvalidTransactionPaymentMethod.class,
                () -> transactionService.processTransaction(transactions));
    }
}