package com.krungsri.workshop.tdd.cal;

public class CalculatorImpl implements Calculator {
    @Override
    public Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
