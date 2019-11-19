package com.example.algorithm.剑指offer;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class PrintListFromTailToHead {

    @Test
    public void test() {

        ListNode listNode = new ListNode(4);

        printListFromTailToHead(listNode);

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = Lists.newArrayList();
        while(listNode != null){
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
