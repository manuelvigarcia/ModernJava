package com.learnJava.funtionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String,Double>> smartStudentListToMap = ((List<Student> students) ->{
       Map<String,Double> smartPantsMap = new HashMap<>();
       students.forEach(student -> {
           if(PredicateStudentExample.p1.test(student)){
               smartPantsMap.put(student.getName(), student.getGpa());
           }
       });
       return smartPantsMap;
    });

    static Function<List<Student>, Map<String,Double>> studentListToMap = (students ->{
        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach((student ->{
            studentGradeMap.put(student.getName(), student.getGpa());
        }));
        return studentGradeMap;
    });

    public static void main(String[] args) {

        System.out.println(studentListToMap.apply(StudentDataBase.getAllStudents()));

        System.out.println(smartStudentListToMap.apply(StudentDataBase.getAllStudents()));
    }
}
