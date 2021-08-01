package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/1 21:23
 */
public class GenerateParentheses {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs("", n, n);
        return res;
    }
    public void dfs(String s, int left, int right){
        if (left == 0 && right == 0){
            res.add(s);
        }
        else {
            if (left == right){
                dfs(s + "(", left - 1, right);
            }
            else if (left < right){
                if (left > 0){
                    dfs(s + "(", left - 1, right);
                }
                dfs(s + ")", left, right-1);
            }
        }
    }
}
