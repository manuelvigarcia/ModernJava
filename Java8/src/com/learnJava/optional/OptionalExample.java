package com.learnJava.optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
    /*
    Optional<T> provides a substitute for null values, allowing to continue execution until the value is actually needed.
    In this use case we get the name of a student --which may or may not be found-- and print the length of the name.
     */
    public static String getStudentName(boolean isStudentFound){
        Student student = StudentDataBase.getAnyStudent(true);
        return (isStudentFound?student.getName():null);
    }

    public static Optional<String> getOptionalStudentName(boolean isStudentFound){
        //we do exactly the same: get the name from getStudentName()
        return Optional.ofNullable(getStudentName(isStudentFound));
    }

    public static void main(String[] args) {
        System.out.print("Student name length: ");
        String name1 = getStudentName(true);
        if (name1 != null){
            System.out.println(name1.length());
        } else{
            System.out.println("(no student found)");
        }
        //now simulate the student not found case:
        System.out.print("Student name length: ");
        String name2 = getStudentName(false);
        if (name2 != null){
            System.out.println("<" + name2.length() + ">");
        } else{
            System.out.println("(no student found)");
        }

        //Now lets try with the help of Optional
        Optional<String> name3 = getOptionalStudentName(true);
        System.out.println("Student name length: " + name3.map(s-> "<" + s.length() + ">").orElse("(no student found"));
        Optional<String> name4 = getOptionalStudentName(false);
        System.out.println("Student name length: " + name4.map(s-> "<" + s.length() + ">").orElse("(no student found"));
        //We achieved the same result using simpler code.
    }
}
