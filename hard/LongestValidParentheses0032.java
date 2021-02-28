package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/27 09:58
 */
public class LongestValidParentheses0032 {
    public int longestValidParentheses(String s) {
        if (s.length()<2){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        stack.addLast(-1);
        for (int i=0; i<len; i++){
            if (chars[i] == '('){
                stack.addLast(i);
            }
            else {
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
