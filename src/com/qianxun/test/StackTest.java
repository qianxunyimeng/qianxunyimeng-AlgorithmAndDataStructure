package com.qianxun.test;

import com.qianxun.栈.ArrayStack;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.test
 * @Author: shiqingliang
 * @CreateTime: 2022-05-17  23:40
 * @Description: TODO
 * @Version: 1.0
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
