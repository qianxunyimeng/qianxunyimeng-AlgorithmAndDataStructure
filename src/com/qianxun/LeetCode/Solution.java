package com.qianxun.LeetCode;

import java.util.Stack;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: com.qianxun.LeetCode
 * @Author: shiqingliang
 * @CreateTime: 2022-05-17  23:51
 * @Description: 括号匹配问题
 * @Version: 1.0
 */
public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                   return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
