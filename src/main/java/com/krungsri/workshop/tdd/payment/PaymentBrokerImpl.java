package com.krungsri.workshop.tdd.payment;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PaymentBrokerImpl implements PaymentBroker {
    private final WalletInterface wallet;
    private final PaymentProviderInterface provider;

    public PaymentBrokerImpl(WalletInterface wallet, PaymentProviderInterface provider) {
        this.wallet = wallet;
        this.provider = provider;
    }

    @Override
    public boolean pay(int amount) {
       throw new NotImplementedException();
    }
}
