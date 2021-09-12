package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/12 10:35
 */
public class ValidParenthesisString0678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        // 出i到j的字串是否满足
        boolean[][] dp = new boolean[n][n];
        // 初始化，长度为1的字符串
        for (int i=0; i<n; i++){
            if (s.charAt(i) == '*'){
                dp[i][i] = true;
            }
        }
        // 初始化，长度为2的字符串
        for (int i=1; i<n; i++){
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            dp[i-1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
        }
        for (int i=n-3; i>=0; i--){
            char c1 = s.charAt(i);
            for (int j=i+2; j<n; j++){
                char c2 = s.charAt(j);
                // 如果ij两端的符合条件，只需要看内部的是否符合条件
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')){
                    dp[i][j] = dp[i+1][j-1];
                }
                // ij两端的不符合条件，需看[i,k]，[k+1,j]是否满足
                for (int k=i; k<j && !dp[i][j]; k++){
                    dp[i][j] = dp[i][k] && dp[k+1][j];
                }
            }
        }
        return dp[0][n-1];
    }

    public boolean checkValidString2(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        // 左括号栈和星号栈可能还有元素。为了将每个左括号匹配，需要将星号看成右括号，
        // 且每个左括号必须出现在其匹配的星号之前。当两个栈都不为空时，
        // 每次从左括号栈和星号栈分别弹出栈顶元素，对应左括号下标和星号下标，判断是否可以匹配，匹
        // 配的条件是左括号下标小于星号下标，如果左括号下标大于星号下标则返回 false。
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public boolean checkValidString3(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }


}
