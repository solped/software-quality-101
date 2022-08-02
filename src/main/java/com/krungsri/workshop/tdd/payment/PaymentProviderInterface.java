package com.krungsri.workshop.tdd.payment;

public interface PaymentProviderInterface {
    boolean isAvailable();

    boolean deposit(int walletId, int amount);
}
