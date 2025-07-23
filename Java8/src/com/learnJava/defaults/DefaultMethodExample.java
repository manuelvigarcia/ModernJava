package com.learnJava.defaults;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {
    /*
    default keyword allows adding new methods to interfaces without interfering with existing classes implementing the
    interface: with the default keyword the interface itself includes a implementation of the method that the
    implementing classes may or may not override.

    Try the sorting operation in the List interface.
     */
    public static void main(String[] args) {
        List<String> names = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .toList();  // --> this list is immutable, so it has to be copied for each use.
        sortPriorToDefault(new ArrayList<>(names));
        sortAfterDefault(new ArrayList<>(names));
    }

    private static void sortAfterDefault(ArrayList<String> namesList) {
        System.out.println("Using default methods in List.");
        System.out.println(namesList);
        namesList.sort(Comparator.reverseOrder());
        System.out.println(namesList);
        namesList.sort(Comparator.naturalOrder());
        System.out.println(namesList);
    }

    private static void sortPriorToDefault(List<String> namesList) {
        System.out.println("Using the Collections methods.");
        System.out.println(namesList);
        Collections.sort(namesList, Collections.reverseOrder());
        System.out.println(namesList);
        Collections.sort(namesList);
        System.out.println(namesList);
    }
}
