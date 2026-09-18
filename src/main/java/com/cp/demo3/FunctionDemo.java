package com.cp.demo3;

import java.util.function.Function;

public class FunctionDemo {


    public static void main(String[] args) {
//        Function<Integer,String> function=new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) {
//                return String.valueOf(integer);
//            }
//        };
        Function<Integer,String> function=(number)->{
            return String.valueOf(number);
        };
        System.out.println(function.apply(123));
    }
}
