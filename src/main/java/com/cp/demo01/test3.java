package com.cp.demo01;

public class test3 {
}


class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread");
    }
}
class MyThread2 implements Runnable{


    @Override
    public void run() {

    }
}
