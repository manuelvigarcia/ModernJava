package com.learnJava.defaults;

public class MultipleInheritanceClient14 implements Interface1, Interface4{
    //Interface1 and Interface4 have the same method.
    //To resolve the conflict, you must override the method in your implementation class

    public void methodA(){
        System.out.println("Inside Method A " + MultipleInheritanceClient14.class.getSimpleName());
    }

    public static void main(String[] args) {
        MultipleInheritanceClient14 mic14 = new MultipleInheritanceClient14();
        mic14.methodA();
    }
}
