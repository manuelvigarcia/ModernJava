package com.learnJava.defaults;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultSortWithComparator {

    private static final Consumer<Student> studentConsumer = System.out::println;
    private static final Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);
    private static final Comparator<Student> studentGradeComparator = Comparator.comparing(Student::getGradeLevel).thenComparing(Student::getName);
    private static final Comparator<Student> studentGpaComparator = Comparator.comparing(Student::getGpa);
    private static final Comparator<Student> studentGpaDescComparator = Comparator.comparing(Student::getGpa).reversed();
    private static final Comparator<Student> studentNotebooksComparator = Comparator.comparing(Student::getNotebooks);

    public static void sortByName(List<Student> students){
        System.out.println("-----------Sort by name:");
        sortStudents(students, studentNameComparator);
    }

    public static void sortByGrade(List<Student> students){
        System.out.println("-----------Sort by grade:");
        sortStudents(students, studentGradeComparator);
    }

    public static void sortByGpa(List<Student> students){
        System.out.println("-----------Sort by GPA:");
        sortStudents(students, studentGpaComparator);
    }

    public static void sortByWorkDone(List<Student> students){
        System.out.println("-----------Sort by grade:");
        sortStudents(students, studentNotebooksComparator);
    }

    public static void sortByGpaDescending(List<Student> students){
        System.out.println("-----------Sort by GPA (desc):");
        sortStudents(students, studentGpaDescComparator);
    }

    public static void sortStudents(List<Student> students, Comparator<Student> comparator){
        students.stream()
                .sorted(comparator)
                .forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(studentConsumer);
        sortByName(studentList);
        sortByGrade(studentList);
        sortByGpa(studentList);
        sortByGpaDescending(studentList);
    }
}
