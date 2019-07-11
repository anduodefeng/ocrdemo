package com.example.sort;

import com.example.ocr.JsonMapper;
import org.junit.Test;

import java.util.Random;

/** *
 * Description: 选择排序
 * ClassName: SortDemo
 * Author: maze
 * Date: 2019/5/6 14:54
 **/
public class SortDemo {

    private static JsonMapper json = JsonMapper.nonDefaultMapper();

    @Test
    public void sortTest() {

        int[] a = new int[100000];
        for(int i=0;i<100000;i++){
            a[i] = new Random().nextInt(1000000);
        }

        chooseSort(a);
        insertSort(a);
        maopaoSort(a);


    }

    private void chooseSort(int[] a){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<a.length-1;i++){
            int min = i;
            for(int j = i+1; j < a.length;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序时间："+(endTime-startTime));
    }

    private void insertSort(int[] a){
        long startTime = System.currentTimeMillis();
        for(int i = 1; i < a.length; i++){
            int temp = a[i];
            int j;
            for(j = i; j > 0 && a[j-1] > temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序时间："+(endTime-startTime));
    }

    private void maopaoSort(int[] a){
        long startTime = System.currentTimeMillis();
        for(int i = a.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序时间："+(endTime-startTime));
    }

    private void quickSort(int[] a){

        int core = a[0];
        int t1 = 0;     //数组下标，不是数组值
        int t2 = 0;     //数组下标，不是数组值
        for(int i=1;i<a.length;i++){
            if(a[i] > core){
                t1 = i;
                break;
            }
        }
        for(int j=a.length-1;j>=0;j--){
            if(a[j] < core){
                t2 = j;
                break;
            }
        }

        int temp = 0;

        if(t1 == t2){
            temp = a[t1];
            a[t1] = core;
            a[0] = temp;
        }else{
            temp = a[t1];
            a[t1] = a[t2];
            a[t2] = temp;
        }



    }
}
