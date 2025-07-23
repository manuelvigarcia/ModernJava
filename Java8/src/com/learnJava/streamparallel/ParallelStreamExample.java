package com.learnJava.streamparallel;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    static int sumUpTo = 1;

    public static int sumSequential(){
        return IntStream.rangeClosed(1,sumUpTo)
                .sum();
    }

    public static int sumParallel(){
        return IntStream.rangeClosed(1,sumUpTo)
                .parallel()
                .sum();
    }

    public static long checkPerformance(int nofLoops, Supplier<Integer> supplier){
        long init = System.nanoTime();
        for (int i = 0; i < nofLoops; i++) {
            supplier.get();
        }
        long end = System.nanoTime();
        return end-init;
    }

    public static void main(String[] args) {
        sumUpTo = 100000;
        int nofRuns = 20;

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("Sequential sum in " + String.format("%,d",
                checkPerformance(nofRuns,ParallelStreamExample::sumSequential)));
        System.out.println("Parallel   sum in " + String.format("%,d",
                checkPerformance(nofRuns,ParallelStreamExample::sumParallel)));
    }
}
