package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.infrastructure.CreditCardPaymentProvider;
import com.krungsri.workshop.infrastructure.CryptoPaymentProvider;
import com.krungsri.workshop.infrastructure.PaypalPaymentProvider;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.processor.TransactionProcessor;

public class PaymentMethodProviderFactory implements TransactionProcessorFactory {
    @Override
    public TransactionProcessor getProcessor(PaymentMethod paymentMethod) throws InvalidTransactionPaymentMethod {
        switch (paymentMethod) {
            case CREDIT_CARD:
                return new CreditCardPaymentProvider();
            case PAYPAL:
                return new PaypalPaymentProvider();
            case CRYPTO:
                return new CryptoPaymentProvider();
            case NOT_SUPPORT:
                throw new InvalidTransactionPaymentMethod();
            default:
                throw new IllegalStateException("Unexpected value: " + paymentMethod);
        }
    }
}
