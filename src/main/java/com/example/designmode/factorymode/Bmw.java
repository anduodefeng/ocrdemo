package com.example.designmode.factorymode;

public class Bmw implements Car{

    @Override
    public void createCar() {
        System.out.println("宝马生产的car");
    }
}
