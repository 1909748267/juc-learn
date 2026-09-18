package com.cp.pc;

import java.util.Collections;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumer2 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.increment1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.decrement1();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.increment2();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.decrement2();
            }
        }, "D").start();
    }
}

//代码书写口诀：等待；业务；唤醒
class Data2 {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void increment1() {
        lock.lock();
        try {
            while (number != 0) {
                condition1.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void decrement1() {
        lock.lock();
        try {
            while (number != 1) {
                condition2.await();
            }
            number=2;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition3.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void increment2() {
        lock.lock();
        try {
            while (number != 2) {
                condition3.await();
            }
            number=3;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition4.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    public void decrement2() {
        lock.lock();
        try {
            while (number != 3) {
                condition4.await();
            }
            number=0;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
