package com.qianxun.test;

import com.qianxun.队列.ArrayQueue;
import com.qianxun.队列.LoopQueue;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.test
 * @Author: shiqingliang
 * @CreateTime: 2022-05-18  00:46
 * @Description: TODO
 * @Version: 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        //testArrayQueue();
        testLoopQueue();
    }

    public static void testArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        queue.dequeue();
        System.out.println(queue);
    }

    public static void testLoopQueue(){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        queue.dequeue();
        System.out.println(queue);
        System.out.println();
    }
}
