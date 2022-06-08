package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/8 10:22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens){
            if (token.equals("+")){
                int num1 = stack.poll();
                int num2 = stack.poll();
                stack.push(num2 + num1);
            } else if (token.equals("-")){
                int num1 = stack.poll();
                int num2 = stack.poll();
                stack.push(num2 - num1);
            } else if (token.equals("*")){
                int num1 = stack.poll();
                int num2 = stack.poll();
                stack.push(num2 * num1);
            } else if (token.equals("/")){
                int num1 = stack.poll();
                int num2 = stack.poll();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
