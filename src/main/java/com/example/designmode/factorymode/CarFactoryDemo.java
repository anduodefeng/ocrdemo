package com.example.designmode.factorymode;

/** *
 * Description: 工厂模式
 * ClassName: CarFactoryDemo
 * Author: maze
 * Date: 2019/10/18 14:29
 **/
public class CarFactoryDemo {

    public static void main(String[] args){

        Car car = CarFactory.createCar("audi");
        Car car1 = CarFactory.createCar("benci");
        Car car2 = CarFactory.createCar("bmw");

        car.createCar();
        car1.createCar();
        car2.createCar();
    }
}
