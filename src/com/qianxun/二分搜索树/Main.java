package com.qianxun.二分搜索树;

/**
 * @Description: TODO
 * @Author: shiqingliang
 * @CreateTime: 2022-07-25  00:06
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        //bst.preOrder();
       // System.out.println("==========");
        //System.out.println(bst);
        bst.levelOrder();
    }
}
