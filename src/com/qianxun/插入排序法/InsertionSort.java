package com.qianxun.插入排序法;

import com.qianxun.utils.ArrayGenerator;
import com.qianxun.utils.SortingHelper;

import java.util.Arrays;

/**
 * 插入排序法： 依次将后面未排序的插入到前面已排好序的位置上。
 * 将指定数组分为两部分，前面已排序和后面未排序
 * arr[0,i)已排好序
 * arr[i...n)未排序
 * 将arr[i]放到已排序部分的合适位置
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.插入排序法
 * @Author: shiqingliang
 * @CreateTime: 2022-05-10  13:46
 * @Description: TODO
 * @Version: 1.0
 */
public class InsertionSort {

    private InsertionSort(){}

    /**
     * @description: 插入排序 时间复杂度 O(n^2)
     * @author: shiqingliang
     * @date: 2022/5/10 14:45
     * @param: [arr]
     * @return: void
     **/
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            // 将 arr[i] 插入到合适到位置
            for(int j = i;j - 1 >= 0; j--){
                if(arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    /**
     * @description: sort 每次循环都有一个交换的操作，多了几步寻址的动作；
     * sort2每次循环就是直接赋值操作，减少了寻址的动作，所以性能上比sort快上一点。
     * 但是sort2的时间复杂度仍然是 O(n^2)
     * @author: shiqingliang
     * @date: 2022/5/10 15:25
     * @param: [arr]
     * @return: void
     **/
    public static <E extends Comparable<E>> void sort2(E[] arr){
        for(int i = 0; i < arr.length; i++){
            // 将 arr[i] 插入到合适到位置
            E temp = arr[i];
            int j;
            for(j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;

        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){

        for(int i = l; i <= r; i ++){

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("InsertionSort2",arr2);
        }
    }
}
