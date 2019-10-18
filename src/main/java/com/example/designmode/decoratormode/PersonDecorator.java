package com.example.designmode.decoratormode;

public abstract class PersonDecorator implements Person{

    protected Person personDecorator;

    public PersonDecorator(Person personDecorator) {
        this.personDecorator = personDecorator;
    }
}
