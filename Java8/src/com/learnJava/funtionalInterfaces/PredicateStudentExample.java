package com.learnJava.funtionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    public static void filterStudentsByGradeLevel(){
        System.out.println("Filter by Grade level");
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentsByGpaLevel(){
        System.out.println("Filter by GPA level");

        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        }));
    }

public static void filterStudents(){
    System.out.println("Filter by several filters");

    List<Student> studentList = StudentDataBase.getAllStudents();
    studentList.forEach((student -> {
        if (p1.and(p2).test(student)){
            System.out.println(student);
        }
    }));

}

    public static void main(String[] args) {
        filterStudentsByGradeLevel();
        filterStudentsByGpaLevel();
        filterStudents();
    }
}
