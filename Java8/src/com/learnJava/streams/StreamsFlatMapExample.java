package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamsFlatMapExample {
    
    public static Set<String> listStudentActivities(List<Student> students){
        return students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(toSet());
    }

    public static List<Map.Entry<String, Long>> activitiesFrequencies(List<Student> students){
        return students.stream().map(Student::getActivities)
                .flatMap(List::stream)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
    }
    static Comparator<Long> descendingComparator = (a, b) -> b.compareTo(a);

    public static List<Map.Entry<String,Double>> sortMapByKey(Map<String,Double> aMap){
        System.out.println("Locally");
        aMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        return aMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList();

    }

    public static void sortStackOverFlowQuestion(){
        Map<String,Double> myMap = new HashMap<>();
            myMap.put("B046",0.0);
                myMap.put("A061",3.0);
                myMap.put("A071",0.0);
                myMap.put("B085",0.0);
                myMap.put("B075",3.0);
                myMap.put("B076",9.0);
                myMap.put("B086", 3.0);
                myMap.put("B095",0.0);
                myMap.put("B096",0.0);
                myMap.put("A052",0.0);
                myMap.put("B066", 0.0);
                myMap.put("B056", 9.0);
                myMap.put("B065",0.0);
                myMap.put("B055",9.0);
        System.out.println(myMap);
        System.out.println(sortMapByKey(myMap));
    }


    public static void main(String[] args) {
        List<Student> allStudents = StudentDataBase.getAllStudents();
        //get all activities
        Set<String> allActivities = listStudentActivities(allStudents);
        System.out.print("All activities from all students:");
        allActivities.stream().sorted().forEach(s-> System.out.print(" " + s + ","));
        //See how many students practice each activity
        System.out.println();
        System.out.print("Activities with popularity: " + activitiesFrequencies(allStudents));
        System.out.println("\nMap sorting");
        sortStackOverFlowQuestion();
    }
}
