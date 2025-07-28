package com.modernjava.var;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VarTypeExample {


    //var in the class properties are not allowed.
    //private var x = "abc";



    public static void main(String[] args) {

        var list = List.of("adam", "dilip");
        System.out.println("List: " + list);

        var map = Map.ofEntries(Map.entry("a", List.of("adam","dilip")));
        System.out.println(map);

        map.forEach((s,strings) -> System.out.println("s= " + s + " contains: " + strings));

        var name = transform("oneName");
        System.out.println(name);
    }

    static String transform(String name) { // var in the function argument is not allowed

        return name.toUpperCase();

    }

}

