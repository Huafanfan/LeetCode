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
        int max = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len];
        for (int i=1; i<len; i++){
            if (chars[i] == ')'){
                //if (chars[i - 1] == '('){
                //    dp[i] = ( i >= 2 ? dp[i-2] : 0) + 2;
                //}
                //else if ((i - dp[i-1] > 0) && chars[i - dp[i-1] -1] == '('){
                //    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                //}
                if ((i - dp[i-1] > 0) && chars[i - dp[i-1] -1] == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    public int longestValidParentheses2(String s) {
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

    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
