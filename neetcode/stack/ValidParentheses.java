package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/7 09:50
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            } else if (c == '['){
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.poll()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
