package com.qianxun.归并排序法;

import com.qianxun.插入排序法.InsertionSort;

import java.util.Arrays;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.归并排序法
 * @Author: shiqingliang
 * @CreateTime: 2022-05-19  23:11
 * @Description: 归并排序对序列的元素进行逐层折半分组，然后从最小分组开始比较排序，合并成一个大的分组，逐层进行，最终所有的元素都是有序的。
 * 例如： 把一个数组从中间位置分成左右两个数组，依次分下去，然后将数组两两比较，合并成一个有序的小数组，并逐层向上合并。
 * 时间复杂度： 每次将序列折半分组，共需要logn轮，因此归并排序算法的时间复杂度是O(nlogn)
 * 空间复杂度：排序过程中需要额外的一个序列去存储排序后的结果，所占空间是n，因此空间复杂度为O(n)
 * @Version: 1.0
 */
public class MergeSort<E> {
    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int startIndex, int endIndex){

        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        sort(arr, startIndex, midIndex);
        sort(arr, midIndex + 1, endIndex);

        //当左边当有序序列当最后一个元素比右边有序序列当第一个元素大当时候才需要将两个有序序列重新合并成一个有序序列。这一步判断是非常重要当性能优化
        if(arr[midIndex].compareTo(arr[midIndex+1]) > 0){
            merge(arr, startIndex, midIndex, endIndex);
        }
    }


    public static <E extends Comparable<E>> void sort2(E[] arr){

        sort2(arr, 0, arr.length - 1);
    }

    // sort2 当数据2⃣量少时，使用插入排序，提升一点性能
    private static <E extends Comparable<E>> void sort2(E[] arr, int startIndex, int endIndex){
        if(endIndex - startIndex <= 15){//优化1
            InsertionSort.sort(arr,startIndex,endIndex);
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        sort(arr, startIndex, midIndex);
        sort(arr, midIndex + 1, endIndex);

        //当左边当有序序列当最后一个元素比右边有序序列当第一个元素大当时候才需要将两个有序序列重新合并成一个有序序列。这一步判断是非常重要当性能优化
        if(arr[midIndex].compareTo(arr[midIndex+1]) > 0){//优化2
            merge(arr, startIndex, midIndex, endIndex);
        }
    }
    // 合并两个有序的区间 arr[startIndex, midIndex] 和 arr[midIndex + 1, endIndex]
    private static <E extends Comparable<E>> void merge(E[] arr, int startIndex, int midIndex, int endIndex){
        // 将原数组有序的两部分拷贝出来，注意 copyOfRange方法截取范围 【from,to),所以这里要endIndex + 1
        E[] temp = Arrays.copyOfRange(arr,startIndex,endIndex + 1);

        /**
         * p1指向 arr[startIndex,midIndex]的第一个元素
         * p2指向 arr[midIndex + 1,endIndex]的第一个元素
         * 两个有序序列依次比较，如果arr[p1] < arr[p2] 则p1++, k++,否则p2++,k++
         */
        int p1 = startIndex;
        int p2 = midIndex + 1;

        for (int k = startIndex; k <= endIndex ; k++) {

            if(p1 > midIndex){ //左侧序列已经比较完毕，右侧序列有剩余，依次将右侧序列剩余元素插入到arr
                arr[k] = temp[p2 - startIndex];
                p2++;
            }else if(p2 > endIndex){//右侧序列已经比较完毕，左侧序列有剩余，依次将左侧剩余元素插入arr
                arr[k] = temp[p1 - startIndex];
                p1++;
            }else if(temp[p1 - startIndex].compareTo(temp[p2 - startIndex]) <= 0){ //arr[p1] <= arr[p2]
                arr[k] = temp[p1 - startIndex];
                p1++;
            }else{
                //arr[p1] > arr[p2]
                arr[k] = temp[p2 - startIndex];
                p2++;
            }
        }
    }

    // merge2方法比merge更容易理解
    private static <E extends Comparable<E>> void merge2(E[] arr, int startIndex, int midIndex, int endIndex){
        E[] temp = Arrays.copyOfRange(arr,startIndex,endIndex+1);
        int p1 = startIndex;
        int p2 = midIndex + 1;
        int p = 0;

        while(p1 <= midIndex && p2 <= endIndex){
            if(arr[p1].compareTo(arr[p2]) <= 0){
                temp[p] = arr[p1];
                p++;
                p1++;
            }else{
                temp[p] = arr[p2];
                p++;
                p2++;
            }
        }

        // 右侧小数组已排序完毕，左侧小数组还有剩余，将左侧小数组元素依次放入大数组尾部
        while (p1 <= midIndex) {
            temp[p++] = arr[p1++];
        }
        // 左侧小数组已排序完毕，右侧小数组还有剩余，将右侧小数组元素依次放入大数组尾部
        while (p2 <= endIndex) {
            temp[p++] = arr[p2++];
        }

        //此时temp数组为有序的数组，将temp再更新到原arr数组中
        for (int i = 0; i < temp.length; i++) {
            arr[i + startIndex] = temp[i];
        }

    }


    public static <E extends Comparable> void sort3(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);
        sort3(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable> void sort3(E[] arr, int l, int r, E[] temp){

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        sort3(arr, l, mid, temp);
        sort3(arr, mid + 1, r, temp);

        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge3(arr, l, mid, r, temp);
    }

    private static <E extends Comparable> void merge3(E[] arr, int l, int mid, int r, E[] temp){

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i]; i ++;
            }
            else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i]; i ++;
            }
            else{
                arr[k] = temp[j]; j ++;
            }
        }
    }



}
