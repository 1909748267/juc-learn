package com.cp.demo3;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> consumer=(str)->{
            System.out.println(str);
        };
        consumer.accept("hello");
    }
}
