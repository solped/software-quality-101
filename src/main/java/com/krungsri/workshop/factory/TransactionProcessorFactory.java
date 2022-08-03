package com.krungsri.workshop.factory;

import com.krungsri.workshop.exception.InvalidTransactionPaymentMethod;
import com.krungsri.workshop.model.PaymentMethod;
import com.krungsri.workshop.processor.TransactionProcessor;

public interface TransactionProcessorFactory {
    TransactionProcessor getProcessor(PaymentMethod paymentMethod) throws InvalidTransactionPaymentMethod;
}
