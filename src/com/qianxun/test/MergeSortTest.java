package com.qianxun.test;

import com.qianxun.utils.ArrayGenerator;
import com.qianxun.utils.SortingHelper;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: shiqingliang
 * @CreateTime: 2022-05-20  00:23
 * @Version: 1.0
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000,1000000,10000000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
            Integer[] arr4 = Arrays.copyOf(arr, arr.length);

            //SortingHelper.sortTest("SelectionSort", arr);
            //SortingHelper.sortTest("InsertionSort", arr2);
            SortingHelper.sortTest("MergeSort", arr3);
            SortingHelper.sortTest("MergeSort2", arr2);
            SortingHelper.sortTest("MergeSort3", arr4);
            System.out.println("====================");
        }
    }
}
