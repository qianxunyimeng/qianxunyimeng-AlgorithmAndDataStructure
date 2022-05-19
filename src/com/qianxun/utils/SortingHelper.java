package com.qianxun.utils;

import com.qianxun.归并排序法.MergeSort;
import com.qianxun.插入排序法.InsertionSort;
import com.qianxun.选择排序法.SelectionSort;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: PACKAGE_NAME
 * @Author: shiqingliang
 * @CreateTime: 2022-05-09  23:47
 * @Description: TODO
 * @Version: 1.0
 */
public class SortingHelper {
    private SortingHelper(){}

    /**
     * @description: 判断一个数组是否是有序的
     * @author: shiqingliang
     * @date: 2022/5/9 23:50
     * @param: [arr]
     * @return: boolean
     **/
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i - 1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;

    }


    public static <E extends Comparable<E>>void sortTest(String sortName,E[] arr){

        long startTime = System.nanoTime();
        if("SelectionSort".equals(sortName)){
            SelectionSort.sort(arr);
        }else if("InsertionSort".equals(sortName)){
            InsertionSort.sort(arr);
        }else if("InsertionSort2".equals(sortName)){
            InsertionSort.sort2(arr);
        } else if("MergeSort".equals(sortName)){
            MergeSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000.0;
        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException(sortName + " failed!");
        }
        System.out.println(String.format("%s , n = %d : %f ms",sortName,arr.length,time));
    }
}
