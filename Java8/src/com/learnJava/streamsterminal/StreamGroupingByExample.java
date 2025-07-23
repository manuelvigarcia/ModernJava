package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    //Top GPA studend per grade
    public static void calculateTopGpa(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa)))));
        //To access the object inside the optional:
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get))));
        //To list only the names
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(toMap(Student::getGradeLevel, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Student::getGpa))))
                .entrySet()
                .stream()
                .map(e-> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
    //Lowest GPA studend per grade
    public static void calculateLowestGpa(){
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        minBy(Comparator.comparing(Student::getGpa)))));
        //To access the object inside the optional:
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa)),
                                Optional::get))));
        //To list only the names
        System.out.println(StudentDataBase.getAllStudents()
                .stream()
                .collect(toMap(Student::getGradeLevel, Function.identity(), BinaryOperator.minBy(Comparator.comparing(Student::getGpa))))
                .entrySet()
                .stream()
                .map(e-> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
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
        System.out.println("Top GPA student by grade:");
        calculateTopGpa();
        System.out.println("Lowest GPA student by grade:");
        calculateLowestGpa();
    }
}
