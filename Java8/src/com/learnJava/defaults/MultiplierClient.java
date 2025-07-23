package com.learnJava.defaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplierClient {
    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> intList = Arrays.asList(1,3,5);
        System.out.println("Result is: " + multiplier.multiply(intList));
        System.out.println("default method size is: " + multiplier.size(intList));
        System.out.println("Static method isEmpty says: " + Multiplier.isEmpty(intList));
        System.out.println("Static method isEmpty says: " + Multiplier.isEmpty(new ArrayList<>()));
    }
}
