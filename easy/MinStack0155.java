package com.huafanfan;

import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/5 10:15
 */
public class MinStack0155 {
    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    public MinStack0155(){
        data = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * 两栈同步
     * 时间复杂度：O(1)，“出栈”、“入栈”、“查看栈顶元素”的操作不论数据规模多大，都只是有限个步骤，因此时
     * 间复杂度是：O(1)。
     * 空间复杂度：O(N)，这里 N 是读出的数据的个数。
     */

    public void push(int x){
        data.add(x);
        if (helper.isEmpty()||helper.peek()>=x){
            helper.add(x);
        }else{
            helper.add(helper.peek());
        }
    }

    /**
     * 两栈不同步
     * 时间复杂度：O(1)，“出栈”、“入栈”、“查看栈顶元素”的操作不论数据规模多大，都只是有限个步骤，因此时
     * 间复杂度是：O(1)。
     * 空间复杂度：O(N)，这里 N 是读出的数据的个数。
     */

    public void pushUnsync(int x){
        data.add(x);
        if (helper.isEmpty()||helper.peek()>=x){
            helper.add(x);
        }
    }

    public void pop(){
        if(!data.isEmpty()){
            helper.pop();
            data.pop();
        }
    }

    public void popUnsync(){
        if(!data.isEmpty()){
            Integer top = data.pop();
            if(top.equals(helper.peek())){
                helper.pop();
            }
        }
    }

    public int top(){
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，非法操作");
    }

    public int getMin(){
        if (!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，非法操作");
    }
    //private Stack<Long> data;
    //private Long stackMin;
    //
    //public MinStack0155(){
    //    data = new Stack<>();
    //    stackMin=Long.MAX_VALUE;
    //}
    //
    //public void push(int x){
    //    data.add((long) x -stackMin);
    //    if(x<stackMin){
    //        stackMin = (long)x;
    //    }
    //}
    //
    //public void pop(){
    //    if(!data.isEmpty()){
    //        Long tmp = data.pop();
    //        if(tmp<0){
    //            stackMin-=tmp;
    //        }
    //    }
    //}
    //
    //public int top(){
    //    if(!data.isEmpty()){
    //        Long tmp = data.peek();
    //        if (tmp<0){
    //            return Math.toIntExact(stackMin);
    //        }
    //        else{
    //            return  Math.toIntExact(stackMin+tmp);
    //        }
    //    }
    //    throw new RuntimeException("栈中元素为空，非法操作");
    //}
    //
    //public int getMin(){
    //    if (!data.isEmpty()){
    //        return  Math.toIntExact(stackMin);
    //    }
    //    throw new RuntimeException("栈中元素为空，非法操作");
    //}

}
