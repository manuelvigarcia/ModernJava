package com.learnJava.optional;

import com.learnJava.data.Bike;
import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

/*
Optional class offers additional methods to process the value with implicit query to isPresent(), so you don't have to
explicitly write the query.

Optional .filter() allows setting a filter on a Optional value (it filters if it is present).
Optional .map() allows processing the value if it is present.
Optional .flatMap() allows access to and processing Optional fields of an Optional value.
 */
public class OptionalMapFlatmapExample {
    public static void main(String[] args) {
        // try with valid student
        Optional<Student> student = Optional.ofNullable(StudentDataBase.getAnyStudent(true));
        orchestrator(student);
    }

    private static void orchestrator(Optional<Student> student) {
        optionalFilter(student);
        optionalMap(student);
        flatMap(student);
    }

    private static void flatMap(Optional<Student> student) {
        System.out.println("Optional flatMap()");
        //if the student is there and if they have a bike, print the bike make.
        System.out.println(student.flatMap(Student::getBike).map(Bike::getMake).orElse("<>"));
    }

    private static void optionalMap(Optional<Student> student) {
        System.out.println("Optional map()");
        // if the student is there, print their name
        System.out.println(student.map(Student::getName).orElse("<>"));
    }

    //Prints the student name if their GPA>=3.7
    private static void optionalFilter(Optional<Student> student) {
        System.out.println("Optional filter()");
        // if the student is there, pritn the name.
        student.filter(s -> s.getGpa() >= 3.7)
                .ifPresent(s -> System.out.println(s.getName()));
    }
}
