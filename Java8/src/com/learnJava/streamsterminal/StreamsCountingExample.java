package com.learnJava.streamsterminal;

import com.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.counting;

public class StreamsCountingExample {
    public static long count(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(counting());
    }
    public static long countFiltered(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student->student.getGpa()>=3.9)
                .collect(counting());
    }
    public static void main(String[] args) {
        System.out.println(count());
        System.out.println(countFiltered());
    }
}
