package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void groupStudentsByGender(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender)));

    }

    public static void customisedGroupingBy(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student-> student.getGpa()>=3.9 ? "OUTSTANDING" : "AVERAGE")));

    }

    public static void twoLevelGrouping_1(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student-> student.getGpa()>=3.9 ? "OUTSTANDING" : "AVERAGE"))));
    }

    public static void twoLevelGrouping_2(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        summingInt(Student::getNotebooks))));
    }

    public static void threeArgumentGroupBy(){
        LinkedHashMap<String, Set<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));
        System.out.println(studentMap);
    }

    public static void main(String[] args) {
        groupStudentsByGender();
        customisedGroupingBy();
        System.out.println("Two level grouping: grade and GPA");
        twoLevelGrouping_1();
        System.out.println("Two level grouping: grade and sum of notebooks");
        twoLevelGrouping_2();
        System.out.println("Three argument GroupBy:");
        threeArgumentGroupBy();
    }
}
