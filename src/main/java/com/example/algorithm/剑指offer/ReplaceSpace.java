package com.example.algorithm.剑指offer;

import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    @Test
    public void test(){
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }

    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replace(" ", "%20");

        return s;
    }
}
