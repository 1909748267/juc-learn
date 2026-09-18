package com.cp.demo3;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
//        Predicate<String> predicate=new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };
        Predicate<String> predicate=(str)->{
            return str.length()>5;
        };
        System.out.println(predicate.test("hello123"));
    }
}
