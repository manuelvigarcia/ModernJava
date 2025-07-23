package com.learnJava.optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {
    /*
    Optional.orElse(), .orElseGet() and .orElseThrow() are methods to treat Optionals without checking .isPresent()
    use .orElse() with a default value as substitute value
    use .orElseGet() with a provider of substitute value
    use .orElseThrow() to signal the absence of value with an exception.
     */
    private static String getStudentNameOrElse(Optional<Student> student) {
        return student.map(Student::getName).orElse("John Doe");
    }

    private static String getStudentNameOrElseGet(Optional<Student> student) {
        return student.map(Student::getName).orElseGet(()-> StudentDataBase.studentSupplier.get().getName());
    }

    private static String getStudentNameOrElseTrow(Optional<Student> student) {
        return student.map(Student::getName).orElseThrow(()->new IllegalStateException("Student not found"));
    }

    public static Optional<Student> getAStudent(boolean isStudentFound){
        return Optional.ofNullable(StudentDataBase.getAnyStudent(isStudentFound));
    }

    public static void printName(String name){
        System.out.println("Student name: " + name);
    }

    public static void main(String[] args) {
        // orElse()
        printName(getStudentNameOrElse(getAStudent(true)));
        printName(getStudentNameOrElse(getAStudent(false)));
        // orElseGet()
        printName(getStudentNameOrElseGet(getAStudent(true)));
        printName(getStudentNameOrElseGet(getAStudent(false)));
        // orElseThrow()
        printName(getStudentNameOrElseTrow(getAStudent(true)));
        try{
            printName(getStudentNameOrElseTrow(getAStudent(false)));
            throw new RuntimeException("An expected exception did not occur.");
        } catch(IllegalStateException ise){
            System.out.println("Student name: " + "(Expected exception because the student was not found.)");
        }

    }

}
