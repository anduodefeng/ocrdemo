package com.example.designmode.decoratormode;

public class AddPersonDecorator extends PersonDecorator{


    public AddPersonDecorator(Person personDecorator) {
        super(personDecorator);
    }

    @Override
    public void sleep() {
        personDecorator.sleep();
        eat();
    }

    private void eat(){
        System.out.println("还可以吃饭！！！");
    }
}
