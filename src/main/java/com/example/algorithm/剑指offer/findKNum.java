package com.example.algorithm.剑指offer;



public class findKNum {

    public static void main(String[] args) throws Exception {
        ListNode listNode = createListNode();
        System.out.println(findNum(1, listNode));
    }


    private static ListNode createListNode(){
        //构造1,2,3,4,5,6,7 的单链表
        ListNode listNode = new ListNode(0);
        ListNode tempNode = listNode;
        for(int i=1;i<8;i++){
            ListNode listNode2 = new ListNode(i);
            tempNode.next = listNode2;
            tempNode = listNode2;
        }

        return listNode.next;
    }

    private static int findNum(int target, ListNode listNode) throws Exception {
        int totalNum = 0;
        ListNode listNode1 = listNode;
        while(listNode != null){
            listNode = listNode.next;
            totalNum++;
        }
        if(target > totalNum){
            throw new Exception();
        }
        if(target<0){
            throw new Exception();
        }
        int num = 0;
        while(listNode1 != null){
            if(num == totalNum - target){
                return listNode1.value;
            }
            listNode1 = listNode1.next;
            num++;
        }

        throw new Exception();
    }


    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
