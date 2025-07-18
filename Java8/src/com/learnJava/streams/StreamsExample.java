package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

        // student name and their activities to a map
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMap); // All the students

        // Filtered by a condition
        Map<String, List<String>> filteredStudentMap = StudentDataBase.getAllStudents().stream()
                .filter((student -> student.getGradeLevel()>=3))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(filteredStudentMap); // Only students with a grade >= 3

        // Filtered by a condition in a predicate.
        Predicate<Student>studentGradePredicate = (student -> student.getGradeLevel()>=3);
        Map<String, List<String>> predicateFilteredStudentMap = StudentDataBase.getAllStudents().stream()
                .filter(studentGradePredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(predicateFilteredStudentMap); // Same result as the previous one

        //Filtered by more than one condition in predicates.
        Predicate<Student> studentGpaPredicate = (student -> student.getGpa()>=3.9);
        long initTime = System.nanoTime();
        Map<String, List<String>> predicatesFilteredStudentMap = StudentDataBase.getAllStudents().stream()
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        long endTime = System.nanoTime();
        System.out.println(predicatesFilteredStudentMap); // students with grade >= 3 and GPA >= 3.9
        System.out.println("nanoseconds: " + String.format("%,d", (endTime-initTime))); //min of 0.26 ms.

        //Same code just in parallel stream
        initTime = System.nanoTime();
        Map<String, List<String>> parallelPredicatesFilteredStudentMap = StudentDataBase.getAllStudents().parallelStream()
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        endTime = System.nanoTime();
        System.out.println(parallelPredicatesFilteredStudentMap); // students with grade >= 3 and GPA >= 3.9
        System.out.println("nanoseconds: " + String.format("%,d", (endTime-initTime))); //min of 3.1 ms

        //Verify that streams are lazy.  -> NOpe. They all call the getAllStudents().
        // All these operations do not trigger the StudentDatabase getALLStudents() method
        System.out.println("Stream");
        Stream<Student> stream1 = StudentDataBase.getAllStudents(true).stream();

        System.out.println("Filtered stream");
        Stream<Student> studentStream1 = StudentDataBase.getAllStudents(true).stream()
                .filter(studentGradePredicate);

        System.out.println("Double filtered stream");
        Stream<Student> studentStream2 = StudentDataBase.getAllStudents(true).stream()
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate);

        // But this one, with a "collector" terminal operation, does.
        System.out.println("resulting map");
        Map<String, List<String>> collected = StudentDataBase.getAllStudents(true).stream()
                .filter(studentGradePredicate)
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        // to debug streams you may divide them in steps or you can use the peek method
        System.out.println("Peek inside the stream operations" +
                "");
        Map<String, List<String>> debuggableStream = StudentDataBase.getAllStudents().stream()
                .peek((student -> System.out.println("Init: " + student.getName())))
                .filter(studentGradePredicate)
                .peek((student -> System.out.println("1 st: " + student.getName())))
                .filter(studentGpaPredicate)
                .peek((student -> System.out.println("2 nd: " + student.getName())))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
                /* This prints the output in the order of traversing. You can extract the text from the console and sort it:
                    Init: Sophia
                    Init: Jenny
                    Init: James
                    Init: Emily
                    Init: Dave
                    Init: Adam

                    1 st: Sophia
                    1 st: James
                    1 st: Emily
                    1 st: Dave

                    2 nd: James
                    2 nd: Emily
                    2 nd: Dave

                So you see which elements pass each step.
                 */
    }
}
