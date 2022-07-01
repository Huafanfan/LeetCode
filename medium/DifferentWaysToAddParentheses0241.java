package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/1 11:27
 */
public class DifferentWaysToAddParentheses0241 {
    char[] cs;
    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0, cs.length-1);
    }
    public List<Integer> dfs(int l, int r){
        List<Integer> ans = new ArrayList<>();
        for (int i=l; i<=r; i++){
            if (cs[i] >= '0' && cs[i] <= '9'){
                continue;
            }
            List<Integer> left = dfs(l, i-1), right = dfs(i+1, r);
            for (Integer a : left){
                for (Integer b : right){
                    int cur = 0;
                    if (cs[i] == '+'){
                        cur = a + b;
                    } else if (cs[i] == '-'){
                        cur = a - b;
                    } else {
                        cur = a * b;
                    }
                    ans.add(cur);
                }
            }
        }
        // 只有一个数字，不是表达式。
        if (ans.isEmpty()){
            int cur = 0;
            for (int i = l; i <= r; i++) {
                cur = cur * 10 + (cs[i] - '0');
            }
            ans.add(cur);
        }
        return ans;
    }

    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        char[] array = input.toCharArray();
        int num = 0;
        for (char c : array) {
            if (isOperation(c)) {
                numList.add(num);
                num = 0;
                opList.add(c);
                continue;
            }
            num = num * 10 + c - '0';
        }
        numList.add(num);
        // 数字的个数
        int N = numList.size();

        // 一个数字
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(numList.get(i));
            dp[i][i] = result;
        }
        // 2 个数字到 N 个数字
        for (int n = 2; n <= N; n++) {
            // 开始下标
            for (int i = 0; i < N; i++) {
                // 结束下标
                int j = i + n - 1;
                if (j >= N) {
                    break;
                }
                ArrayList<Integer> result = new ArrayList<>();
                // 分成 i ~ s 和 s+1 ~ j 两部分
                for (int s = i; s < j; s++) {
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for (Integer value1 : result1) {
                        for (Integer value2 : result2) {
                            // 第 s 个数字下标对应是第 s 个运算符
                            char op = opList.get(s);
                            result.add(calculate(value1, op, value2));
                        }
                    }
                }
                dp[i][j] = result;

            }
        }
        return dp[0][N-1];
    }

    private int calculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses0241 d = new DifferentWaysToAddParentheses0241();
        System.out.println(d.diffWaysToCompute("2*3-4*5"));
    }
}
