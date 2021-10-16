package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/16 13:43
 */
public class ExpressionAddOperators0282 {
    List<String> ans = new ArrayList<>();
    String s;
    int n,t;
    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return ans;
    }

    public void dfs(int u, long prev, long cur, String ss){
        if (u == n){
            if (cur == t){
                ans.add(ss);
            }
        }
        for (int i=u; i<n; i++){
            if (i != u && s.charAt(u) == '0'){
                break;
            }
            long next = Long.parseLong(s.substring(u, i+1));
            if (u == 0){
                dfs(i+1, next, next, "" + next);
            }
            else {
                dfs(i+1, next, cur + next, ss + "+" + next);
                dfs(i+1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                dfs(i+1, x, cur - prev + x, ss + "*" + next);
            }
        }
    }
}
