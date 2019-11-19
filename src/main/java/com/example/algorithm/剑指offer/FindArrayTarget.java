package com.example.algorithm.剑指offer;

import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindArrayTarget {


    @Test
    public void test(){
        int[][] i = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(find(3, i));
    }

    public boolean find(int target, int [][] array) {
        int length = array.length;
        if(length == 0){
            return false;
        }
        int length2 = array[0].length;
        if(length2 == 0){
            return false;
        }
        int row = length - 1;
        int col = 0;
        while(row >= 0 && col < length2){
            if(array[row][col] < target){
                col++;
            }else if(array[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}
