package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.infrastructure.CreditCardPaymentProvider;
import com.krungsri.workshop.infrastructure.CryptoPaymentProvider;
import com.krungsri.workshop.infrastructure.PaypalPaymentProvider;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.processor.TransactionProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodProviderFactoryTest {

    @Test
    void getProcessor_whenPaymentMethodIsCreditCard_thenReturnCreditCarProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod creditCard = PaymentMethod.CREDIT_CARD;
        PaymentMethodProviderFactory paymentMethodProviderFactory = new PaymentMethodProviderFactory();

        // when
        TransactionProcessor processor = paymentMethodProviderFactory.getProcessor(creditCard);

        // then
        assertTrue(processor instanceof CreditCardPaymentProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsPayPal_thenReturnPayPalProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod paypal = PaymentMethod.PAYPAL;
        PaymentMethodProviderFactory paymentMethodProviderFactory = new PaymentMethodProviderFactory();

        // when
        TransactionProcessor processor = paymentMethodProviderFactory.getProcessor(paypal);

        // then
        assertTrue(processor instanceof PaypalPaymentProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsCrypto_thenReturnCryptoProvider() throws InvalidTransactionPaymentMethod {
        // given
        PaymentMethod crypto = PaymentMethod.CRYPTO;
        PaymentMethodProviderFactory paymentMethodProviderFactory = new PaymentMethodProviderFactory();

        // when
        TransactionProcessor processor = paymentMethodProviderFactory.getProcessor(crypto);

        // then
        assertTrue(processor instanceof CryptoPaymentProvider);
    }

    @Test
    void getProcessor_whenPaymentMethodIsNotSupport_thenThrowInvalidTransactionPaymentMethod() {
        // given
        PaymentMethod notSupport = PaymentMethod.NOT_SUPPORT;
        PaymentMethodProviderFactory paymentMethodProviderFactory = new PaymentMethodProviderFactory();

        // when & then
        assertThrows(InvalidTransactionPaymentMethod.class,
                () -> paymentMethodProviderFactory.getProcessor(notSupport));
    }
}