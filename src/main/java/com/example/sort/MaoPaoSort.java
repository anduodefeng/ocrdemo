package com.example.sort;

import com.example.ocr.JsonMapper;

/** *
 * Description: 冒泡排序
 * ClassName: MaoPaoSort
 * Author: maze
 * Date: 2019/5/6 14:22
 **/
public class MaoPaoSort {

    private static JsonMapper json = JsonMapper.nonDefaultMapper();
    private static int[] a = new int[]{3,56,2,55,87,6,56,8,332,456,34,65};

    public static void main(String[] args){

        for(int i = a.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println(json.toJson(a));

    }
}
