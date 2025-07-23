package com.learnJava.streamparallel;

public class SumServer {
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private int sum = 0;

    public void performSum(int value){
        sum+=value;
    }
}
