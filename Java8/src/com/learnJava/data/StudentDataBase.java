package com.learnJava.data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class StudentDataBase {

    public static Supplier<Student> studentSupplier = () -> getAllStudents().getFirst();

    public static Student getAnyStudent(boolean isStudentFound){
        if (!isStudentFound) return null;
        List<Student> allStudents = getAllStudents();
        Random rnd = new Random(System.nanoTime());
        return(allStudents.get(rnd.nextInt(allStudents.size())));
    }
    /**
     * Total of 6 students in the database.
     * @return list of all students in the database.
     */
    public static List<Student> getAllStudents(){

        /*
         * 2nd grade students
         */
        Student student1 = new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"), 11);
        student1.setBike(Optional.of(new Bike("GreatBikes", "EasyRider", 1881)));
        Student student2 = new Student("Jenny",2,3.8,"female", Arrays.asList("swimming", "gymnastics","soccer"), 12);
        /*
         * 3rd grade students
         */
        Student student3 = new Student("Emily",3,4.0,"female", Arrays.asList("swimming", "gymnastics","aerobics"),10);
        Student student4 = new Student("Dave",3,3.9,"male", Arrays.asList("swimming", "gymnastics","soccer"),9);
        /*
         * 4th grade students
         */
        Student student5 = new Student("Sophia",4,3.5,"female", Arrays.asList("swimming", "dancing","football"),15);
        Student student6 = new Student("James",4,3.9,"male", Arrays.asList("swimming", "basketball","baseball","football"),14);

        return Arrays.asList(student1,student2,student3,student4,student5,student6);
    }
    public static List<Student> getAllStudents(boolean traceThis){
        if (traceThis){
            System.out.println("Obtaining all students data from Database.");
        }
        return getAllStudents();
    }
}
