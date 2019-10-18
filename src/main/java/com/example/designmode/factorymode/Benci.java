package com.example.designmode.factorymode;

public class Benci implements Car{
    @Override
    public void createCar() {
        System.out.println("奔驰生产的car");
    }
}
