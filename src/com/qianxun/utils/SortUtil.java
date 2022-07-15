package com.qianxun.utils;

/**
 * @Description: TODO
 * @Author: shiqingliang
 * @CreateTime: 2022-07-15  10:13
 * @Version: 1.0
 */
public class SortUtil {

    /**
     * 将arr数组索引i和索引j对位置交换
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    public static <E> void swap(E[] arr, int i,int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
