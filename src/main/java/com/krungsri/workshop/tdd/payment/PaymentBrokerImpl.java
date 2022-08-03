package com.krungsri.workshop.tdd.payment;


public class PaymentBrokerImpl implements PaymentBroker {
    private final WalletInterface wallet;
    private final PaymentProviderInterface provider;

    public PaymentBrokerImpl(WalletInterface wallet, PaymentProviderInterface provider) {
        this.wallet = wallet;
        this.provider = provider;
    }

    @Override
    public boolean pay(int amount) throws InsufficientFundsException, ProviderNotAvailableException {
        if (wallet.getBalance() < amount) {
            throw new InsufficientFundsException();
        }
        if (!provider.isAvailable()) {
            throw new ProviderNotAvailableException();
        }
        return provider.deposit(wallet.getId(), amount);
    }
}
