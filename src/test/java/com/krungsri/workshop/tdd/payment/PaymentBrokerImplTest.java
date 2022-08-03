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

    }

    @Test
    void givenWalletDoesntHasFunds_whenPay_thenThrowInsufficientFundsException() throws ProviderNotAvailableException, InsufficientFundsException {

    }

    @Test
    void givenProviderIsUnAvailable_whenPay_thenThrowProviderNotAvailableException() throws ProviderNotAvailableException, InsufficientFundsException {

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