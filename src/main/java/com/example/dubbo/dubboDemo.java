package com.example.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PayService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class dubboDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("pay-consumer.xml");

        PayService payService = (PayService) context.getBean("payService");
        System.out.println(payService.consume());

//        for(int i=0;i<10;i++){
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//            thread.start();
//        }

    }
}
