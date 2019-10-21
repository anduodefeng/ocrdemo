package com.example.demo;

import com.example.ocr.JsonMapper;
import com.google.common.base.Strings;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) throws Exception {

//        JsonMapper json = JsonMapper.nonDefaultMapper();
//        Person person = new Person();
//        Class clazz = Class.forName("com.example.demo.Person");
//
//        Field field = clazz.getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(person, "张三");
//
//        System.out.println(json.toJson(clazz.newInstance()));

        int[] i = new int[10];
        i = Arrays.copyOf(i, 15);
        System.out.println(i.length);
    }
}
