package com.learnJava.streamparallel;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParallelStreamExample1 {

    public static void getStudentsActivities(){
        long init = System.nanoTime();
        StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
        long end = System.nanoTime();
        System.out.println("sequential: " + (end-init));
    }

    public static void getStudentsActivitiesParallel(){
        long init = System.nanoTime();
        StudentDataBase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());
        long end = System.nanoTime();
        System.out.println("parallel: " + (end-init));
    }

    public static void main(String[] args) {
        getStudentsActivities();
        getStudentsActivitiesParallel();
    }
}
