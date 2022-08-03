package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentType;
import com.krungsri.workshop.model.PaymentType;

public class TransactionProcessorAbstractFactory {
    public TransactionProcessorFactory getProviderFactory(PaymentType paymentType) throws InvalidTransactionPaymentType {
        switch (paymentType) {
            case PAYMENT:
                return new PaymentMethodProviderFactory();
            case REFUND:
                return new RefundMethodProviderFactory();
            case INVALID:
                throw new InvalidTransactionPaymentType();
            default:
                throw new IllegalStateException("Unexpected value: " + paymentType);
        }
    }
}
