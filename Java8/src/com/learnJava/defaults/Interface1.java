package com.learnJava.defaults;

public interface Interface1 {
    default void methodA(){
        System.out.println("Inside method A " + Interface1.class.getSimpleName());
    }
}
