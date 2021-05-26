package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/26 10:42
 */
public class ReverseSubstringsBetweenEachPairOfParentheses1190 {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //进入下一层
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                //当前层结束，返回上一层
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses2(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses1190 reverseSubstringsBetweenEachPairOfParentheses1190 = new ReverseSubstringsBetweenEachPairOfParentheses1190();
        System.out.println(reverseSubstringsBetweenEachPairOfParentheses1190.reverseParentheses2("(u(love)i)"));
    }
}
