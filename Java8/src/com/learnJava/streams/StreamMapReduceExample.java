package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

public class StreamMapReduceExample {

    private static int noOfNotebooks(List<Student> students){
        return students.stream().map(Student::getNotebooks)
                .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        // How many notebooks have all students in total
        int noOfNotebooks = noOfNotebooks(StudentDataBase.getAllStudents());
        System.out.println("Total number of notebooks: " + noOfNotebooks);

        // Compare number of notebooks females have vs. those by males.
        List<Student> students = StudentDataBase.getAllStudents();
        long noOfFemaleStudents = students.stream()
                .filter(s-> s.getGender().equals("female")).count();
        long noOfMaleStudents = students.size() - noOfFemaleStudents;
        int noOfFemaleNotebooks = students.stream()
                .filter(s->s.getGender().equals("female"))
                .map(s-> s.getNotebooks())
                .reduce(0, Integer::sum);
        System.out.println("Female Notebooks average: " + (noOfFemaleNotebooks / noOfFemaleStudents));
        System.out.println("Male Notebooks average: " + (noOfNotebooks - noOfFemaleNotebooks) / noOfMaleStudents);
    }
}
