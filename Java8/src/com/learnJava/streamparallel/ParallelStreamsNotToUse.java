package com.learnJava.streamparallel;

import java.util.stream.IntStream;

public class ParallelStreamsNotToUse {
    /*
    Parallel streams not always give performance boost.
    But more than that, some cases will additionally give wrong results.
    One special such case is when dealing with mutable variables. This class exemplifies that case.
     */
    public static void main(String[] args) {
        for (int i = 0; i<20; i++){
            SumServer ss = new SumServer();
            IntStream.rangeClosed(1,10000)
                    .parallel()
                    .forEach(ss::performSum);
            int result = ss.getSum();
            System.out.print(result+", ");
        }
        /*
        sequential execution: 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000, 50005000,
        parallel execution:   50005000, 19886668, 14924240, 20855007, 19197279, 10993282, 20171193, 25843666, 18619218, 35236960, 25186762, 19074864, 19217338, 48361743, 26185428, 39478290, 21807787, 45399939, 18026959, 14764727,
         */
    }
}
