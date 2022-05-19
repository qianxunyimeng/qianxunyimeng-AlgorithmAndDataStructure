package com.qianxun.队列;

import java.util.Stack;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.队列
 * @Author: shiqingliang
 * @CreateTime: 2022-05-19  00:06
 * @Description: 用栈实现队列
 * @Version: 1.0
 */
public class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * @description: 入队
     * @author: shiqingliang
     * @date: 2022/5/19 00:07
     * @param: [x]
     * @return: void
     **/
    public void push(int x) {

        Stack<Integer> stack2 = new Stack<>();

        while(!stack.empty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);

        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    /**
     * @description: 出队
     * @author: shiqingliang
     * @date: 2022/5/19 00:11
     * @param: []
     * @return: int
     **/
    public int pop() {
        return stack.pop();
    }

    /**
     * @description: 查看队
     * @author: shiqingliang
     * @date: 2022/5/19 00:11
     * @param: []
     * @return: int
     **/
    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
