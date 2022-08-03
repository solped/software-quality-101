package com.krungsri.workshop.tdd.payment;


public class PaymentBrokerImpl implements PaymentBroker {
    private final WalletInterface wallet;
    private final PaymentProviderInterface provider;

    public PaymentBrokerImpl(WalletInterface wallet, PaymentProviderInterface provider) {
        this.wallet = wallet;
        this.provider = provider;
    }

    @Override
    public boolean pay(int amount) {
       throw new UnsupportedOperationException();
    }
}
