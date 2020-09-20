package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 10:19
 */
public class Subsets0078 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result = subsets3(new int[]{1,2,3});
        System.out.println(result.toString());
    }

    /**
     * 方法一看不懂
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void dfs(int first, int[] nums) {
        if (first == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[first]);
        dfs(first+1, nums);
        path.remove(path.size()-1);
        dfs(first+1, nums);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        for (int mask = 0; mask < (1<<n); mask++){
            List<Integer> curr = new ArrayList();
            for (int i=0; i<n; i++){
                if ((mask & (1<<i)) != 0){
                    curr.add(nums[i]);
                }
            }
            output.add(curr);
        }
        return output;
        //for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
        //    // generate bitmask, from 0..00 to 1..11
        //    String bitmask = Integer.toBinaryString(i).substring(1);
        //
        //    List<Integer> curr = new ArrayList();
        //    for (int j = 0; j < n; ++j) {
        //        if (bitmask.charAt(j) == '1') {
        //            curr.add(nums[j]);
        //        }
        //    }
        //    output.add(curr);
        //}
        //return output;
    }
}
