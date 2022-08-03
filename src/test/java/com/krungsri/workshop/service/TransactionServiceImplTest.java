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
    }
}