package com.example.algorithm.stackandqueue;

import java.util.Stack;

/** *
 * Description: 获取最小值栈
 * Author: maze
 * Date: 2019/10/14 18:58
 * Params:
 * Return:
 **/
public class GetMinStackDemo {

    private Stack<Integer> stackData = new Stack<>();

    private Stack<Integer> stackMin = new Stack<>();

    //数据入栈
    public void push(int num) throws Exception {
        stackData.push(num);
        if(stackMin.empty()){
            stackMin.push(num);
        }else if(num <= this.getMin()){
            stackMin.push(num);
        }
    }

    //数据出栈
    public int pop() throws Exception {
        if(stackData.empty())
            throw new Exception("栈为空");
        int i = stackData.pop();
        if(i == this.getMin()){
            stackMin.pop();
        }

        return i;
    }

    //获取最小值栈的最小值
    private int getMin() throws Exception{
        if(stackMin.empty())
            throw new Exception("栈为空");

        return stackMin.peek();
    }
}
