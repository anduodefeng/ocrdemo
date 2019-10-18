package com.example.designmode.decoratormode;

public class Teacher implements Person {
    @Override
    public void sleep() {
        System.out.println("老师也要睡觉!!!");
    }
}
