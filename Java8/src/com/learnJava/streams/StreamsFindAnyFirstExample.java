package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {
    public static Optional<Student> findAnyStudent(Double desiredGpa){
        return StudentDataBase.getAllStudents().stream()
                .filter(student-> student.getGpa()>=desiredGpa)
                .findAny();
    }

    public static Optional<Student> findFirstStudent(Double gpa){
        return StudentDataBase.getAllStudents().stream()
                .filter(student-> student.getGpa()>=gpa)
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println("A student with GPA >=3.9: " + findAnyStudent(3.9).map(Student::getName).orElse("<>"));
        System.out.println("A student with GPA >=3.9: " + findFirstStudent(3.9).map(Student::getName).orElse("<>"));
        System.out.println("A student with GPA >=4.1: " + findFirstStudent(4.1).map(Student::getName).orElse("<>"));
    }
}
