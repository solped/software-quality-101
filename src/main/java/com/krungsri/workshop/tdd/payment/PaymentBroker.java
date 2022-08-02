package com.krungsri.workshop.tdd.payment;

public interface PaymentBroker {
    boolean pay(int amount) throws InsufficientFundsException, ProviderNotAvailableException;
}
