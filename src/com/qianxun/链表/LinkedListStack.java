package com.qianxun.链表;

import com.qianxun.栈.Stack;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.链表
 * @Author: shiqingliang
 * @CreateTime: 2022-05-19  21:19
 * @Description: 用链表实现栈
 * @Version: 1.0
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop(){
        return list.removeFirst();
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
