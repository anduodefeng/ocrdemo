package com.example.designmode.decoratormode;

public class Student implements Person{
    @Override
    public void sleep() {
        System.out.println("学生要睡觉！！");
    }
}
