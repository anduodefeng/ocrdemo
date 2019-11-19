package com.example.algorithm.剑指offer;

import org.junit.Test;

import java.util.Arrays;

public class TreeNode {

    @Test
    public void test(){

        int[] pre =  {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        Tree t = reConstructBinaryTree(pre, in);

        System.out.println(t);
    }


    private Tree reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }

        Tree root = new Tree(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i] == root.val){
                //左子树 递归
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1,i+1), Arrays.copyOfRange(in, 0,i));
                //右子树 递归
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in,i+1,in.length));

                break;
            }
        }

        return root;

    }

}

class Tree{
    public int val;

    public Tree left;

    public Tree right;

    public Tree(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
