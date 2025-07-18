package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

public class StreamDistinctCountSortExample {
    public static void main(String[] args) {
        System.out.println("All the activities practiced by all students");
        StudentDataBase.getAllStudents().stream()
                .map(s-> s.getActivities())
                .flatMap(List::stream)
                .forEach(System.out::println);
        System.out.println("There are repetitions. Remove repetitions.");

        StudentDataBase.getAllStudents().stream()
                .map(s-> s.getActivities())
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println("They are unsorted. Sort alphabetically");
        StudentDataBase.getAllStudents().stream()
                .map(s-> s.getActivities())
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("Now they are nice");
    }
}
