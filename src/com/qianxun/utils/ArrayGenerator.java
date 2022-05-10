package com.qianxun.utils;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generateOrderArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }


    /**
     * @description: 生成一个长度为n的随机数组，每个数字范围是 [0,bound)
     * @author: shiqingliang
     * @date: 2022/5/9 23:17
     * @param: [n, bound]
     * @return: java.lang.Integer[]
     **/
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
