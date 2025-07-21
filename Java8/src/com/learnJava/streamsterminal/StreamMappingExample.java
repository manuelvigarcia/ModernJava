package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {

    public static void main(String[] args) {
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList())));

        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet())));
    }
}
