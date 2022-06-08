package neetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/8 10:33
 */
public class GenerateParentheses {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrace("", 0, 0, n);
        return res;
    }

    public void backtrace(String s, int open, int close, int n){
        if (open == n && close == n){
            res.add(s);
            return;
        }
        if (open < n) {
            backtrace(s + "(", open + 1, close, n);
        }
        if (close < open){
            backtrace(s + ")", open, close + 1, n);
        }
        //if (open == close){
        //    backtrace(s + "(" , open + 1, close, n);
        //} else {
        //    if (open < n) {
        //        backtrace(s + "(", open + 1, close, n);
        //    }
        //    if (close < n) {
        //        backtrace(s + ")", open, close + 1, n);
        //    }
        //}
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }
}
