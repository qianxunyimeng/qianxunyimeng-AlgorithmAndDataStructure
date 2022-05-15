package com.qianxun.test;

import com.qianxun.数组.Array;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.test
 * @Author: shiqingliang
 * @CreateTime: 2022-05-15  00:58
 * @Description: TODO
 * @Version: 1.0
 */
public class Arraytest {

    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());
        arr.add(1,100);
        System.out.println(arr.toString());

        arr.remove(1);
        System.out.println(arr.toString());

        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        System.out.println(arr.toString());
        arr.removeElement(10);
        System.out.println(arr.toString());
        arr.removeAllElement(10);
        System.out.println(arr.toString());

    }
}
