package com.learnJava.defaults;

import java.util.List;

public class MultiplierImpl implements Multiplier{

    @Override
    public int multiply(List<Integer> integersList) {
        return integersList.stream()
                .reduce(1, (x,y) -> x*y);
    }

    @Override
    public int size(List<Integer> integersList) {
        System.out.println("Inside MultiplierImpl");
        return (int) integersList.stream()
                .count();
    }

}
