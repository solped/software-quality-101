package com.krungsri.workshop.tdd.cal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {

    @Test
    void givenBothNumberArePositive_whenCallSum_thenShouldReturnPositive() {
        //given
        Integer number1 = 1;
        Integer number2 = 2;

        //when
        Integer actualResult = new CalculatorImpl().sum(number1, number2);

        //then
        Assertions.assertTrue(actualResult > 0);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    void givenBothNumberAreNegative_whenCallSum_thenShouldReturnNegative() {
        //given
        Integer number1 = -2;
        Integer number2 = -3;

        //when
        Integer actualResult = new CalculatorImpl().sum(number1, number2);

        //then
        Assertions.assertTrue(actualResult < 0);
        Assertions.assertEquals(-5, actualResult);
    }

    @Test
    void givenBothNumberAreOpposite_whenCallSum_thenShouldReturnZero() {
        //given
        Integer number1 = 5;
        Integer number2 = -5;

        //when
        Integer actualResult = new CalculatorImpl().sum(number1, number2);

        //then
        Assertions.assertEquals(0, actualResult);
    }

}