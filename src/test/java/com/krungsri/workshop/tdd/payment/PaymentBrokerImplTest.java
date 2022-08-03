package com.krungsri.workshop.tdd.payment;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class PaymentBrokerImplTest {

    @Test
    void givenWalletHasFundsProviderIsAvailableAndDepositSucceed_whenPay_thenReturnTrue() throws ProviderNotAvailableException, InsufficientFundsException {
        // given
        int amount = 10;
        int balance = 20;
        WalletInterface wallet = mock(WalletInterface.class);
        PaymentProviderInterface provider = mock(PaymentProviderInterface.class);
        PaymentBrokerImpl paymentBroker = new PaymentBrokerImpl(wallet, provider);

        when(wallet.getBalance()).thenReturn(balance);
        when(provider.isAvailable()).thenReturn(true);
        when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

        // when
        boolean isSucceed = paymentBroker.pay(amount);

        // then
        assertTrue(isSucceed);
    }

    @Test
    void givenWalletDoesntHasFunds_whenPay_thenThrowInsufficientFundsException() throws ProviderNotAvailableException, InsufficientFundsException {
        // given
        int amount = 10;
        int balance = 0;
        WalletInterface wallet = mock(WalletInterface.class);
        PaymentProviderInterface provider = mock(PaymentProviderInterface.class);
        PaymentBrokerImpl paymentBroker = new PaymentBrokerImpl(wallet, provider);

        when(wallet.getBalance()).thenReturn(balance);
        when(provider.isAvailable()).thenReturn(true);
        when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

        // when & then
        Assert.assertThrows(InsufficientFundsException.class, () -> paymentBroker.pay(amount));
    }

    @Test
    void givenProviderIsUnAvailable_whenPay_thenThrowProviderNotAvailableException() throws ProviderNotAvailableException, InsufficientFundsException {
        // given
        int amount = 10;
        int balance = 20;
        WalletInterface wallet = mock(WalletInterface.class);
        PaymentProviderInterface provider = mock(PaymentProviderInterface.class);
        PaymentBrokerImpl paymentBroker = new PaymentBrokerImpl(wallet, provider);

        when(wallet.getBalance()).thenReturn(balance);
        when(provider.isAvailable()).thenReturn(false);
        when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

        // when & then
        Assert.assertThrows(ProviderNotAvailableException.class, () -> paymentBroker.pay(amount));
    }


    // =============== mock vs spy ================== //
//    @Test
//    public void whenCreateMock_thenCreated() {
//        List mockedList = mock(ArrayList.class);
//        mockedList.add("one");
//
//        verify(mockedList).add("one");
//        assertEquals(0, mockedList.size());
//    }
//
//    @Test
//    public void whenCreateSpy_thenCreate() {
//        List spyList = spy(new ArrayList());
//        spyList.add("one");
//        verify(spyList).add("one");
//
//        assertEquals(1, spyList.size());
//    }

}