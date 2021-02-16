package microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 20:04
 */
public class ValidParentheses0020 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.addLast(')');
            }
            if (aChar == '[') {
                stack.addLast(']');
            }
            if (aChar == '{') {
                stack.addLast('}');
            }
            if (aChar == ')') {
                if (stack.removeLast() != aChar) {
                    return false;
                }
            }
            if (aChar == ']') {
                if (stack.removeLast() != aChar) {
                    return false;
                }
            }
            if (aChar == '}') {
                if (stack.removeLast() != aChar) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
