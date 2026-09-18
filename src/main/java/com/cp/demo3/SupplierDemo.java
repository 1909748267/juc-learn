package com.cp.demo3;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier=new Supplier<String>() {
//            @Override
//            public String get() {
//                return "你是🐷";
//            }
//        };
        Supplier<String> supplier=()->"你是🐷";
        System.out.println(supplier.get());
    }
}
