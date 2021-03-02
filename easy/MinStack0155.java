package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/5 10:15
 */
public class MinStack0155 {
    private Deque<Integer> data;
    private Deque<Integer> helper;

    public MinStack0155(){
        data = new LinkedList<>();
        helper = new LinkedList<>();
        helper.push(Integer.MAX_VALUE);
    }

    public void push(int x){
        data.push(x);
        helper.push(Math.min(helper.peek(), x));
    }

    public void pop(){
        helper.pop();
        data.pop();
    }

    public int top(){
        return data.peek();
    }

    public int getMin(){
        return helper.peek();
    }
}
