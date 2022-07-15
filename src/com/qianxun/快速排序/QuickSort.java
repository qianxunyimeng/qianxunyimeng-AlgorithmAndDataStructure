package com.qianxun.快速排序;

import com.qianxun.utils.ArrayGenerator;
import com.qianxun.utils.SortUtil;
import com.qianxun.utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 快速排序算法的核心就是找到一个标定点partition,标定点左边的都比他小，右边的都比它大。依次递归循环下去。
 * 第一次默认将第一个数值当作标定点。
 * QuickSort(arr,l,r)对arr对【l,r】部分排序
 * Quicksort(arrml,r){
 *     if l >= r return;
 *     int p = partition(arr,l,r)
 *     //对arr【l,p-1】进行排序
 *     QuickSort(arr,l,p-1);
 *     //对arr[p=1,r]进行排序
 *     QuickSort(arr,p+1,r)
 * }
 * @Author: shiqingliang
 * @CreateTime: 2022-07-14  20:30
 * @Version: 1.0
 */
public class QuickSort {
    //私有构造函数
    private  QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random rnd = new Random();
        sort(arr,0,arr.length - 1,rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r,Random rnd){
        //递归到底
        if(l >= r){
            return;
        }
        //递归排序
        int p = partition(arr,l,r,rnd); //索引p位置将数组arr分成两个小数组，p左边都比arr[p]小，右边都比arr[p]大，再分别对这两个数组递归排序

        sort(arr,l,p - 1,rnd);
        sort(arr, p + 1,r,rnd);

    }

    // 对arr[l,r]部分排序,这一版对于完全有序对数组，时间复杂度将变为O(n^2),递归深度O(n)
    private static <E extends Comparable<E>> int partition(E[] arr,int l,int r,Random rnd){

        // 生成 【l,r】之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        //将arr[p]放到首位
        SortUtil.swap(arr,l,p);

        // arr[l+1,...,j] < v 数组1
        // arr[j+1,...,i] >= v 数组2

        //arr[i]待比较的数值，每次比较完毕确定arr[i]的位置，如果比arr[l]大，就把它加入到数组2的末尾（i++），
        // 如果比arr[l]小，就j++，并交换arr[j]和arr[i]
        int j = l;
        for (int i = l + 1; i <= r; i++){
            if(arr[i].compareTo(arr[l]) < 0){// arr[i] < arr[l]
                j++;
                SortUtil.swap(arr,i,j);
            }
        }
        //循环一遍，交换arr[l]和arr[j],将标定点arr[l]摆放到最终的位置，
        SortUtil.swap(arr,l,j);
        return j;
    }



    /** 双路快速排序算法 start  */
    public static <E extends Comparable<E>> void sort2ways(E[] arr){
        Random rnd = new Random();
        sort2ways(arr,0,arr.length - 1,rnd);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr,int l,int r,Random rnd){
        //递归到底
        if(l >= r){
            return;
        }
        //递归排序
        int p = partition2(arr,l,r,rnd); //索引p位置将数组arr分成两个小数组，p左边都比arr[p]小，右边都比arr[p]大，再分别对这两个数组递归排序

        sort2ways(arr,l,p - 1,rnd);
        sort2ways(arr, p + 1,r,rnd);

    }

    // 对arr[l,r]部分排序,这一版对于完全有序对数组，时间复杂度将变为O(n^2),递归深度O(n)
    private static <E extends Comparable<E>> int partition2(E[] arr,int l,int r,Random rnd){

        // 生成 【l,r】之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        //将arr[p]放到首位
        SortUtil.swap(arr,l,p);


        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true){

            while (i <= j && arr[i].compareTo(arr[l]) < 0){//左侧依次向右查找比标定点大的点
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0){//右侧依次向左查找比标定点小的点
                j--;
            }

            if(i >= j){
               break;
            }

            SortUtil.swap(arr,i,j);
            i++;
            j--;
        }

        //将标定点摆放到正确到位置上
        SortUtil.swap(arr,l,j);
        return j;
    }

    /**  双路快速排序算法 ending  */



    /** 三路快速排序算法 start   */
    public static <E extends Comparable<E>> void sort3ways(E[] arr){
        Random rnd = new Random();
        sort3ways(arr,0,arr.length - 1,rnd);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr,int l,int r,Random rnd){
        //递归到底
        if(l >= r){
            return;
        }

        int p = l + rnd.nextInt(r - l + 1);
        SortUtil.swap(arr,l,p);

        // arr[l+1,lt] < v; arr[lt+1, i-1] == v; arr[gt,r] > v
        int lt = l, i = l + 1,gt = r + 1;
        while(i < gt){
            if(arr[i].compareTo(arr[l]) < 0){
                lt++;
                SortUtil.swap(arr,i,lt);
                i++;
            }else if(arr[i].compareTo(arr[l]) > 0){
                gt--;
                SortUtil.swap(arr,i,gt);
            }else{// arr[i] == arr[l]
                i++;
            }
        }
        SortUtil.swap(arr,l,lt);
        // arr[l,lt-1] < v; arr[lt, gt-1] == v; arr[gt,r] > v
        sort3ways(arr,l,lt - 1,rnd);
        sort3ways(arr,gt,r,rnd);
    }



    /** 三路快速排序算法 ending   */




    /**    */

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);
        System.out.println();


        arr = ArrayGenerator.generateOrderArray(n);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);
        System.out.println("Order Array");
        SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);
        System.out.println();

        arr = ArrayGenerator.generateRandomArray(n,1);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);
        System.out.println("Same Value Array");
        //SortingHelper.sortTest("QuickSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);

    }


}
