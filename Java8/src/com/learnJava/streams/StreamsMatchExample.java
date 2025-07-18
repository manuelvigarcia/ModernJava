package com.learnJava.streams;

import com.learnJava.data.StudentDataBase;

public class StreamsMatchExample {
    public static boolean allMatch(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.9);
    }

    public static boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()==4.0);
    }

    public static boolean noneMatch(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student-> student.getGpa() < 3.5);
    }

    public static void main(String[] args) {
        System.out.println("Do all students have GPA of 3.9 or higher? " + allMatch());
        System.out.println("Is there any student with GPA of 4? " + anyMatch());
        System.out.println("Are all our students at GPA of 3.5 or higher? " + noneMatch());
    }
}
