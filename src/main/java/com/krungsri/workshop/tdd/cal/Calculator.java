package com.krungsri.workshop.tdd.cal;

public class Calculator implements ICalculator {
    @Override
    public Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
