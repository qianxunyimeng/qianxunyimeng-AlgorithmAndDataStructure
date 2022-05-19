package com.qianxun.test;

import com.qianxun.链表.LinkedList;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.test
 * @Author: shiqingliang
 * @CreateTime: 2022-05-19  21:15
 * @Description: TODO
 * @Version: 1.0
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
    }
}
