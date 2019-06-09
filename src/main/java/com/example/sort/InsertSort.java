package com.example.sort;

import com.example.ocr.JsonMapper;

/** *
 * Description: 插入排序
 * ClassName: InsertSort
 * Author: maze
 * Date: 2019/5/6 14:32
 **/
public class InsertSort {

    private static JsonMapper json = JsonMapper.nonDefaultMapper();
    private static int[] a = new int[]{3,56,2,55,87,6,56,8,332,456,34,65};

    public static void main(String[] args){

        for(int i = 1; i < a.length; i++){
            int temp = a[i];
            int j;
            for(j = i; j > 0 && a[j-1] > temp;j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }

        System.out.println(json.toJson(a));
    }
}
