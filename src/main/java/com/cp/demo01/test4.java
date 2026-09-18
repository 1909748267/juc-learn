package com.cp.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test4 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for (int i = 0; i < 30; i++)
                ticket.sale();
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++)
                ticket.sale();
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++)
                ticket.sale();
            },"C").start();
    }

}

class Ticket{
    private int ticket = 20;
    public synchronized void sale(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余票数为：" + (--ticket));
        }else{
            System.out.println("票已售罄");
        }
    }
}
