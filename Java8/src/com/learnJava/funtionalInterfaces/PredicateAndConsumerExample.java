package com.learnJava.funtionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;

    Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    BiPredicate<Integer,Double> bothConditions = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa>=3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name,activities) -> System.out.println(name + ": " + activities);

    Consumer<Student> studentConsumer = (student ->{
        if(p1.and(p2).test(student)){
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    Consumer<Student> studentConsumerBiPredicate = (student ->{
        if(bothConditions.test(student.getGradeLevel(),student.getGpa())){
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });


    public void printNameAndActivities(List<Student> students){

        students.forEach(studentConsumer);
        System.out.println("Separator");
        students.forEach(studentConsumerBiPredicate);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();

        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }
}
