package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/14 12:02
 */
public class CombinationSumiii0216 {
    public static void main(String[] args) {
        CombinationSumiii0216 combinationSumiii0216 = new CombinationSumiii0216();
        System.out.println(combinationSumiii0216.combinationSum3(3,9));
    }
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); ++mask) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    public boolean check(int mask, int k, int n) {
        temp.clear();
        for (int i = 0; i < 9; ++i) {
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum == n;
    }

    public List<List<Integer>> combinationSum3DFS(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }
    public void dfs(int cur, int n, int k, int sum){
        if (temp.size() + (n-cur+1) < k || temp.size() > k){
            return;
        }
        if (temp.size() == k){
            int tempSum = 0;
            for (int num : temp){
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur+1, n, k, sum);
        temp.remove(temp.size()-1);
        dfs(cur+1, n, k, sum);
    }

}
