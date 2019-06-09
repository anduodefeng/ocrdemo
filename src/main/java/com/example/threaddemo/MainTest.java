package com.example.threaddemo;


import com.example.ocr.JsonMapper;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MainTest {

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    private static JsonMapper json = JsonMapper.nonDefaultMapper();

    public static void main(String[] args){

//        final String[] s = {"张三"};
//        stringThreadLocal.set(s[0]);
//
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                s[0] = "李四";
//                stringThreadLocal.set(s[0]);
//                System.out.println("线程thread："+json.toJson(stringThreadLocal.get()));
//            }
//        };
//        thread.start();
//
//        String s1 = stringThreadLocal.get();
//
//        System.out.println("main方法：" + json.toJson(s1));

        Runnable runnable = new ARunnable();
        for(int i=0;i<150;i++){

            Thread thread = new Thread(runnable);
            thread.start();

        }
    }
}
