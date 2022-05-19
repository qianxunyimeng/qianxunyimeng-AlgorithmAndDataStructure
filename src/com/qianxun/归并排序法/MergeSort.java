package com.qianxun.归并排序法;

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
        merge(arr, startIndex, midIndex, endIndex);
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

}
