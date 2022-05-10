package com.qianxun.选择排序法;

import com.qianxun.utils.ArrayGenerator;
import com.qianxun.utils.SortingHelper;

/**
 * 选择排序算法的思想就是每次循环都从剩余数据中选择一个最小的，放在已排好序的末尾
 */
public class SelectionSort {
    private SelectionSort() {
    }
    
    /**
     * @description: 选择排序算法 时间复杂度 O(n^2)
     * @author: shiqingliang
     * @date: 2022/5/9 22:40
     * @param: [arr]
     * @return: void
     **/
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 假设 起始位置的数据是最小的
            int minIndex = i;
            // 每一轮循环都从arr[i...n) 中选择出最小值对应的索引
            for (int j = i; j < arr.length; j++) {
                // compareTo返回< 0 前者 小于后者
                //             > 0 前者 大于 后者
                //             = 0 前者 等于 后者
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // 将索引i和minIndex对应的数据交换
            swap(arr, i, minIndex);


        }
    }

    /**
     * @description: 将指定数组中索引i和索引minIndex对应的数据交换位置
     * @author: shiqingliang
     * @date: 2022/5/9 21:03
     * @param: [arr, i, j]
     * @return: void
     **/
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        Student[] arr2 = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SelectionSort.sort(arr2);
        for (Student student : arr2) {
            System.out.print(student + " ");
        }
        System.out.println();

        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] arr3 = ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("SelectionSort",arr3);
        }
    }

}
