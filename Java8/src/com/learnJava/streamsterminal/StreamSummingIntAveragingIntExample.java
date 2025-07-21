package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamSummingIntAveragingIntExample {

    public static int sum(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNotebooks));
    }

    public static double averaging(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNotebooks));
    }

    public static void main(String[] args) {
        System.out.println("nof Notebooks: " + sum());
        System.out.println("Average notebooks by student: " + averaging());
    }
}
