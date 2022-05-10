package com.qianxun.线性查找法;

import com.qianxun.common.Student;
import com.qianxun.utils.ArrayGenerator;


public class LinearSearch {
    // 私有构造函数
    private LinearSearch(){}

    public static void main(String[] args) {
        Integer[] data = {24,18,12,9,16,66,32,4};

        int res = LinearSearch.<Integer>search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);

        Student[] stus = {new Student("Alice",23),new Student("Boob",24),new Student("Charles",25)};
        Student boob = new Student("Boob",24);
        int res3 = LinearSearch.search(stus, boob);
        System.out.println(res3);


        int[] dataSize = {1000000,10000000,100000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderArray(n);
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(arr,n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000.0;
            System.out.printf("n = %d, runs: %d,耗时: %s 毫秒\n",n,100,time);
        }



    }

    /**
     * 在指定数据集中查找指定的目标元素，如果存在返回目标元素在数据集中的索引，如果不存在就返回-1
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param data 数据集
     * @param target 目标元素
     * @return
     */
    public static <E> int search(E[] data,E target){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target) ){
                return i;
            }
        }
        return -1;
    }
}
