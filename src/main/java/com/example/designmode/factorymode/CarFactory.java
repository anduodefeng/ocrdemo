package com.example.designmode.factorymode;

/** *
 * Description: 工厂类
 * ClassName: CarFactory
 * Author: maze
 * Date: 2019/10/18 14:20
 **/
public class CarFactory {

    public static Car createCar(String car){
        if(null == car){
            return null;
        }
        if(car.equalsIgnoreCase("audi")){
            return new Audi();
        }else if(car.equalsIgnoreCase("benci")){
            return new Benci();
        }else if(car.equalsIgnoreCase("bmw")){
            return new Bmw();
        }

        return null;
    }
}
