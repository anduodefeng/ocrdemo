package com.example.designmode.decoratormode;

public class DecoratorModeDemo {

    public static void main(String[] args){

        Person person = new Teacher();

        AddPersonDecorator addPersonDecorator = new AddPersonDecorator(person);
        person.sleep();
        addPersonDecorator.sleep();
    }
}
