package com.learnJava.defaults;

public class MultipleInheritanceClient implements Interface1, Interface2, Interface3{

    public void methodA(){
        System.out.println("Inside method A " + MultipleInheritanceClient.class.getSimpleName());
    }


    public static void main(String[] args) {
        MultipleInheritanceClient mic = new MultipleInheritanceClient();
        mic.methodA(); // Java resolves to the Implementer class, then the childmost Interface.
        mic.methodB();
        mic.methodC();
    }
}
