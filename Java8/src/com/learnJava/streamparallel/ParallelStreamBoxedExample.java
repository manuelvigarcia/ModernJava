package com.learnJava.streamparallel;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ParallelStreamBoxedExample {

    public static int seqSum(List<Integer> integers){
        long init = System.nanoTime();
        int result = integers.stream()
                .reduce(0, Integer::sum);
        long end = System.nanoTime();
        System.out.println("Sequential: "+ String.format("%,d",end - init));
        return result;
    }

    public static int parSum(List<Integer> integers){
        long init = System.nanoTime();
        int result = integers.parallelStream()
                .reduce(0, Integer::sum);
        long end = System.nanoTime();
        System.out.println("Parallel:   "+ String.format("%,d",end - init));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> intList = IntStream.rangeClosed(1, 1000000)
                .boxed()
                .toList();
        seqSum(intList);
        parSum(intList);
    }
}
