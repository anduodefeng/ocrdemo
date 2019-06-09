package com.example.sort;

import com.example.ocr.JsonMapper;

/** *
 * Description: 选择排序
 * ClassName: ChooseSort
 * Author: maze
 * Date: 2019/5/6 14:54
 **/
public class ChooseSort {

    private static JsonMapper json = JsonMapper.nonDefaultMapper();
    private static int[] a = new int[]{3,56,2,55,87,6,56,8,332,456,34,65};

    public static void main(String[] args){

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

        System.out.println(json.toJson(a));
    }
}
