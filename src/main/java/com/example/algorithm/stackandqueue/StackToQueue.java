package com.example.algorithm.stackandqueue;

import java.util.Stack;

/** *
 * Description: 两个栈实现队列操作
 * ClassName: StackToQueue
 * Author: maze
 * Date: 2019/10/14 19:09
 **/
public class StackToQueue {

    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    //添加数
    public void add(int num){
        stack1.push(num);
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }

    //弹出数据
    public int poll() throws Exception {
        if(stack1.empty() && stack2.empty()){
            throw new Exception("栈为空");
        }
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    //返回数据（并不弹出）
    public int peek() throws Exception {
        if(stack1.empty() && stack2.empty()){
            throw new Exception("栈为空");
        }
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }
}
