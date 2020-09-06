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

    List<List<Integer>> output = new ArrayList();
    int n, k;
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            output.add(curr);
        }
        return output;
    }
}
