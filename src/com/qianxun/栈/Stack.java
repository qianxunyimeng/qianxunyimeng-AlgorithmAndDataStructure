package com.qianxun.栈;

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * @description: 压栈
     * @author: shiqingliang
     * @date: 2022/5/17 20:04
     * @param: [e]
     * @return: void
     **/
    void push(E e);

    /**
     * @description: 出栈
     * @author: shiqingliang
     * @date: 2022/5/17 20:05
     * @param: []
     * @return: E
     **/
    E pop();

    /**
     * @description: 查看栈顶顶元素
     * @author: shiqingliang
     * @date: 2022/5/17 20:05
     * @param: []
     * @return: E
     **/
    E peek();


}
