package com.learnJava.funtionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier=()->{
            return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball","Volleyball"), 0);
        };
        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();
        System.out.println("New Student is: " + studentSupplier.get());

        System.out.println("Students are: " + listSupplier.get());
    }
}
