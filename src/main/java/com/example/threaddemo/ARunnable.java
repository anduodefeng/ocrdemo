package com.example.threaddemo;

import java.util.concurrent.locks.ReentrantLock;

public class ARunnable implements Runnable{

    private int i = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        addNum();
    }

    private void addNum(){

        reentrantLock.lock();
        i++;
        System.out.println(i);
        reentrantLock.unlock();
    }
}
