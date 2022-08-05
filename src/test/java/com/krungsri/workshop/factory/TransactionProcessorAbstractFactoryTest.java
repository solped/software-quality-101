package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.model.PaymentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorAbstractFactoryTest {

    @Test
    void getProviderFactory_whenPaymentTypeIsPayment_thenReturnPaymentFactory()
            throws InvalidTransactionPaymentType {
        // given
        PaymentType paymentType = PaymentType.PAYMENT;
        TransactionProcessorAbstractFactory transactionProcessorAbstractFactory = new TransactionProcessorAbstractFactory();

        // when
        TransactionProcessorFactory providerFactory = transactionProcessorAbstractFactory.getProviderFactory(paymentType);

        // then
        assertTrue(providerFactory instanceof PaymentMethodProviderFactory);
    }

    @Test
    void getProviderFactory_whenPaymentTypeIsRefund_thenReturnRefundFactory()
            throws InvalidTransactionPaymentType {
        // given
        PaymentType paymentType = PaymentType.REFUND;
        TransactionProcessorAbstractFactory transactionProcessorAbstractFactory = new TransactionProcessorAbstractFactory();

        // when

        TransactionProcessorFactory providerFactory = transactionProcessorAbstractFactory.getProviderFactory(paymentType);

        // then
        assertTrue(providerFactory instanceof RefundMethodProviderFactory);
    }

    @Test
    void getProviderFactory_whenPaymentTypeIsInvalid_thenThrowInvalidTransactionPaymentType() {
        // given
        PaymentType paymentType = PaymentType.INVALID;
        TransactionProcessorAbstractFactory transactionProcessorAbstractFactory = new TransactionProcessorAbstractFactory();

        // when & then
        assertThrows(InvalidTransactionPaymentType.class, () ->
                transactionProcessorAbstractFactory.getProviderFactory(paymentType));
    }
}