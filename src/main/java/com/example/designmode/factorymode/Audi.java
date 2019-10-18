package com.example.designmode.factorymode;

public class Audi implements Car{

    @Override
    public void createCar() {
        System.out.println("奥迪生产的car");
    }
}
