package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.infrastructure.CreditCardRefundProvider;
import com.krungsri.workshop.infrastructure.CryptoRefundProvider;
import com.krungsri.workshop.infrastructure.PaypalRefundProvider;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.processor.TransactionProcessor;

public class RefundMethodProviderFactory implements TransactionProcessorFactory {
    @Override
    public TransactionProcessor getProcessor(PaymentMethod paymentMethod) throws InvalidTransactionPaymentMethod {
        switch (paymentMethod) {
            case CREDIT_CARD:
                return new CreditCardRefundProvider();
            case PAYPAL:
                return new PaypalRefundProvider();
            case CRYPTO:
                return new CryptoRefundProvider();
            case NOT_SUPPORT:
                throw new InvalidTransactionPaymentMethod();
            default:
                throw new IllegalStateException("Unexpected value: " + paymentMethod);
        }
    }
}
