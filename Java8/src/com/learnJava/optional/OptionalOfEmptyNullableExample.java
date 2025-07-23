package com.learnJava.optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {
    /*You can use the Optional<T> to encapsulate values that may or may not be null.*/
    public static String getStudentName(boolean isStudentFound){
        Student student = StudentDataBase.getAnyStudent(true);
        return (isStudentFound?student.getName():null);
    }
    // use ofNullable when the object might be null
    public static Optional<String> optionalName(boolean isThere){
        return Optional.ofNullable(getStudentName(isThere));
    }
    //use of() when you control what is in the object
    //use empty() when you want to convey that there is no value
    public static Optional<String> getPossibleName(boolean isThere){
        String name = getStudentName(isThere);
        if (name != null){
            return Optional.of(name);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("There is a student: " + optionalName(true));
        System.out.println("There is a student: " + optionalName(false));

        System.out.println("There is a student: " + getPossibleName(true));
        System.out.println("There is a student: " + getPossibleName(false));
    }
}
