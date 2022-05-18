package com.qianxun.队列;

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * @description: 入队
     * @author: shiqingliang
     * @date: 2022/5/18 00:24
     * @param: [e]
     * @return: void
     **/
    void enqueue(E e);

    /**
     * @description: 出队
     * @author: shiqingliang
     * @date: 2022/5/18 00:24
     * @param: []
     * @return: E
     **/
    E dequeue();

    /**
     * @description: 查看对首元素
     * @author: shiqingliang
     * @date: 2022/5/18 00:24
     * @param: []
     * @return: E
     **/
    E getFront();
}
