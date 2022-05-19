package com.qianxun.test;

import com.qianxun.utils.ArrayGenerator;
import com.qianxun.utils.SortingHelper;

/**
 * @Description: TODO
 * @Author: shiqingliang
 * @CreateTime: 2022-05-20  00:23
 * @Version: 1.0
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("MergeSort", arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
