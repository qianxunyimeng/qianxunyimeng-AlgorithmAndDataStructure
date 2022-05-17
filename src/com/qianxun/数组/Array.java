package com.qianxun.数组;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.数组
 * @Author: shiqingliang
 * @CreateTime: 2022-05-15  00:18
 * @Description: 二次封装动态数组
 * @Version: 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;
    
    /**
     * @description: 构造函数，传入数组的初识容量capacity
     * @author: shiqingliang
     * @date: 2022/5/15 00:20
     * @param: [capacity]
     * @return: 
     **/
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * @description: 无参构造，默认数组初识容量为10
     * @author: shiqingliang
     * @date: 2022/5/15 00:23
     * @param: []
     * @return:
     **/
    public Array(){
        this(10);
    }

    /**
     * @description: 获取数组中元素个数
     * @author: shiqingliang
     * @date: 2022/5/15 00:26
     * @param: []
     * @return: int
     **/
    public int getSize(){
        return this.size;
    }

    /**
     * @description: 获取数组的容量
     * @author: shiqingliang
     * @date: 2022/5/15 00:27
     * @param: []
     * @return: int
     **/
    public int getCapacity(){
        return this.data.length;
    }

    /**
     * @description: 数组是否为空
     * @author: shiqingliang
     * @date: 2022/5/15 00:28
     * @param: []
     * @return: boolean
     **/
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * @description: 追加一个元素
     * @author: shiqingliang
     * @date: 2022/5/15 00:35
     * @param: [e]
     * @return: void
     **/
    public void addLast(E e){
        add(size,e);
    }

    /**
     * @description: 在数组头插入一个新元素e
     * @author: shiqingliang
     * @date: 2022/5/15 00:44
     * @param: [e]
     * @return: void
     **/
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * @description: 在第index个位置上插入一个新元素e
     * @author: shiqingliang
     * @date: 2022/5/15 00:36
     * @param: [index, e]
     * @return: void
     **/
    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }



    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
               return true;
            }
        }
        return false;
    }

    /**
     * @description:查找数组中元素e所在的索引，如果不存在则返回-1
     * @author: shiqingliang
     * @date: 2022/5/15 01:09
     * @param: []
     * @return: int
     **/
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * @description:删除指定索引位置的元素，并将该元素返回
     * @author: shiqingliang
     * @date: 2022/5/15 01:19
     * @param: [index]
     * @return: int
     **/
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        // 方便垃圾回收
        data[size] = null;

        // 数组缩容
        if(size == data.length / 4 && data.length /2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * @description: 从数组中删除元素e，如果存在该元素并删除
     * @author: shiqingliang
     * @date: 2022/5/15 01:25
     * @param: [e]
     * @return: boolean
     **/
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public void removeAllElement(E e){
        int index = find(e);
        while (index != -1){
            remove(index);
            index = find(e);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return  res.toString();
    }

    /**
     * @description: 数组扩容
     * @author: shiqingliang
     * @date: 2022/5/15 17:42
     * @param: [newCapacity] 扩容后的数组容量
     * @return: void
     **/
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }
}
