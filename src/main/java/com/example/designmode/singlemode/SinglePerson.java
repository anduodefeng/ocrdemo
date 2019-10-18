package com.example.designmode.singlemode;

/** *
 * Description: 单例模式实现
 * ClassName: SinglePerson
 * Author: maze
 * Date: 2019/10/18 14:04
 **/
public class SinglePerson {

    //懒汉式单例模式   考虑了多线程问题，不过效率太慢
//    private static Person person;
//
//    public static synchronized Person getInstance(){
//        if(null == person){
//            person = new Person();
//        }
//
//        return person;
//    }
        //饿汉式单例模式 容易多消耗资源
//    private static Person person = new Person();
//
//    public static Person getInstance(){
//        return person;
//    }

    //单例模式 最佳实现(静态内部类方式)
    private static class PersonHolder{
        private static final SinglePerson PERSON = new SinglePerson();
    }

    public static SinglePerson getInstance(){
        return PersonHolder.PERSON;
    }

    private SinglePerson(){}
}
