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
        List<List<Integer>> result = subsetsii0090.subsets2(new int[]{4,4,4,1,4});
        System.out.println(result.toString());
    }
    //public static List<List<Integer>> subsets(int[] nums) {
    //    Set<List<Integer>> output = new HashSet<>();
    //    int n = nums.length;
    //    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
    //        // generate bitmask, from 0..00 to 1..11
    //        String bitmask = Integer.toBinaryString(i).substring(1);
    //
    //        List<Integer> curr = new ArrayList();
    //        for (int j = 0; j < n; ++j) {
    //            if (bitmask.charAt(j) == '1') {
    //                curr.add(nums[j]);
    //            }
    //        }
    //        Collections.sort(curr);
    //        output.add(curr);
    //    }
    //    return new ArrayList<>(output);
    //}

    List<List<Integer>> output = new ArrayList();
    int n, k;
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

    public  List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        backtrack(0, new ArrayList<Integer>(), nums);
        return output;
    }
}
