package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.infrastructure.*;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.processor.TransactionProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefundMethodProviderFactoryTest {

    @Test
    void getProcessor_whenPaymentMethodIsCreditCard_thenReturnCreditCarProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod creditCard = PaymentMethod.CREDIT_CARD;
        RefundMethodProviderFactory refundMethodProviderFactory = new RefundMethodProviderFactory();

        // when
        TransactionProcessor processor = refundMethodProviderFactory.getProcessor(creditCard);

        // then
        assertTrue(processor instanceof CreditCardRefundProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsPayPal_thenReturnPayPalProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod paypal = PaymentMethod.PAYPAL;
        RefundMethodProviderFactory refundMethodProviderFactory = new RefundMethodProviderFactory();

        // when
        TransactionProcessor processor = refundMethodProviderFactory.getProcessor(paypal);

        // then
        assertTrue(processor instanceof PaypalRefundProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsCrypto_thenReturnCryptoProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod crypto = PaymentMethod.CRYPTO;
        RefundMethodProviderFactory refundMethodProviderFactory = new RefundMethodProviderFactory();

        // when
        TransactionProcessor processor = refundMethodProviderFactory.getProcessor(crypto);

        // then
        assertTrue(processor instanceof CryptoRefundProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsNotSupport_thenThrowInvalidTransactionPaymentMethod() {
        // given
        PaymentMethod notSupport = PaymentMethod.NOT_SUPPORT;
        RefundMethodProviderFactory refundMethodProviderFactory = new RefundMethodProviderFactory();

        // when & then
        assertThrows(InvalidTransactionPaymentMethod.class,
                () -> refundMethodProviderFactory.getProcessor(notSupport));
    }
}