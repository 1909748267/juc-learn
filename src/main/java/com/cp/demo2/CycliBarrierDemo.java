package com.cp.demo2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("道爷，我成了！");
        });
        for (int i = 0; i < 5; i++) {
            int temp=i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "功法练好了,目前已经练好"+(temp+1)+"部功法");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i+1)).start();

        }
    }
}
