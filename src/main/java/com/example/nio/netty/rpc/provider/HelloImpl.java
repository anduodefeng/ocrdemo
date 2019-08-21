package com.example.nio.netty.rpc.provider;

import com.example.nio.netty.rpc.api.Hello;

public class HelloImpl implements Hello {

    @Override
    public String sayHello(String name) {

        System.out.println("Hello "+ name + "!");

        return "Hello" + name + "!";
    }
}
