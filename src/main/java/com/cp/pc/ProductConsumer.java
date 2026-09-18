package com.cp.pc;

public class ProductConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.increment();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.decrement();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.increment();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.decrement();
            }
        },"D").start();
    }
}

//代码书写口诀：等待；业务；唤醒
class Data{
    private int number=0;
    public synchronized void increment(){
        while (number!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        notifyAll();
    }
    public synchronized void decrement(){
        while (number==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        notifyAll();
    }
}
