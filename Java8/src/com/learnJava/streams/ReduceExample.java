package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static int multiplyStream(List<Integer> numbersList){
        return numbersList.stream()
                .reduce(1,(a,b) -> a*b);
    }

    public static Student higherGpaStudent(Student s1, Student s2){
        if (s1 == null) return s2;
        if (s2 == null) return s1;
        if (s1.getGpa() >= s2.getGpa()) return s1;
        return s2;
    }

    public static Student highestGpaStudent(List<Student> students){
        return students.stream().reduce(null, ReduceExample::higherGpaStudent);
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println("product of all integers in the list is: " + multiplyStream(integers));

        System.out.println("Highest GPA student");
        System.out.println(highestGpaStudent(StudentDataBase.getAllStudents()));
    }
}
