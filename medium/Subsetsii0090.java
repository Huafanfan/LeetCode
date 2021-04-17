package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 16:10
 */
public class Subsetsii0090 {
    public static void main(String[] args) {
        Subsetsii0090 subsetsii0090 = new Subsetsii0090();
        List<List<Integer>> result = subsetsii0090.subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(result.toString());
    }

    List<List<Integer>> output = new ArrayList();
    int n, k;

    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        backtrack(0, new ArrayList<Integer>(), nums);
        return output;
    }

    public  void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        output.add(new ArrayList(curr));
        for (int i = first; i < n; ++i) {
            if (i > first && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        //没选
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        //选
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
}
