package com.learnJava.lambdas;

public class RunnablLambdaExample {
    public static void main(String[] args) {
        //Before Java8
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        long initTime = System.nanoTime();
        new Thread(runnable).start();
        System.out.println("Runnable: " + String.format("%,d", (System.nanoTime()-initTime)));

        // Java8 lambda syntax
        Runnable runnableLambda = () -> {
            System.out.println("Inside Runnable 2");
        };

        initTime = System.nanoTime();
        new Thread(runnableLambda).start();
        System.out.println("RunnableLambda: " + String.format("%,d", (System.nanoTime()-initTime)));

        // Java8 Lambda simplified syntax
        Runnable runnableLambda2 = () -> System.out.println("Inside Runnable 3");

        initTime = System.nanoTime();
        new Thread(runnableLambda2).start();
        System.out.println("RunnableLambda2: " + String.format("%,d", (System.nanoTime()-initTime)));

        // Java8 Lambda simplified syntax avoiding declaration of the variable
        initTime = System.nanoTime();
        new Thread ( () -> System.out.println("Inside Runable 4")).start();
        System.out.println("RunnableLambda3: " + String.format("%,d", (System.nanoTime()-initTime)));
    }
}
