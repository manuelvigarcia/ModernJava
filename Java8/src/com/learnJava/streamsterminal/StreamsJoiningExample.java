package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsJoiningExample {
    public static String joining_v1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }
    public static String joining_v2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }
    public static String joining_v3(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "(", ")"));
    }
    public static void main(String[] args) {
        System.out.println(joining_v1());
        System.out.println(joining_v2());
        System.out.println(joining_v3());
    }
}
