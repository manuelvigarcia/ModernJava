package com.learnJava.streamsterminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample {
    /*
    PartitioningBy divides the input stream in two: those which verify the predicate parameter and those which don't.
    The result is a map with two entries: "false" for those which don't and "true" for those which do. The value of
    the entries is a list with the input values for each case. It may take a second parameter to override the
    default list output with a different collector, like toSet() or the like.
    As an example, let's take the list of all students and separate them in GPA>=3.8
     */
    static Predicate<Student> gpa3_8OrMore = s -> s.getGpa()>=3.8;

    public static Map<Boolean, List<Student>> partitionByGpaDefaultList(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpa3_8OrMore));
    }

    public static Map<Boolean, Set<Student>> partitionByGpaToSet(){
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpa3_8OrMore,Collectors.toSet()));
    }

    public static void main(String[] args) {
        System.out.println(partitionByGpaDefaultList());
        System.out.println(partitionByGpaToSet());
    }
}
