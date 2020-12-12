package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 09:17
 */
public class WiggleSubsequence0376 {
    /**
     * 1 17 5 10 5
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        return dfs(nums,0, new ArrayList<>());
    }

    /**
     * 超时
     * @param nums
     * @param index
     * @param seq
     * @return
     */
    public int dfs(int[] nums, int index, List<Integer> seq){
        if (index > nums.length-1){
            return 0;
        }
        else {
            int maxLength = -1;
            for (int i=index; i<nums.length; i++){
                if (seq.size()<1){
                    seq.add(nums[i]);
                    int length = dfs(nums, i+1, seq) + 1;
                    maxLength = Math.max(maxLength, length);
                    seq.remove(seq.size()-1);
                }
                else if (seq.size()<2){
                    int beforeNum = seq.get(0);
                    if (beforeNum!=nums[i]){
                        seq.add(nums[i]);
                        int length = dfs(nums, i+1, seq) + 1;
                        maxLength = Math.max(maxLength, length);
                        seq.remove(seq.size()-1);
                    }
                }
                else {
                    int beforeNum = seq.get(seq.size()-1);
                    int beforeBeforeNum = seq.get(seq.size()-2);
                    if (beforeNum - beforeBeforeNum > 0){
                        if (nums[i] - beforeNum < 0){
                            seq.add(nums[i]);
                            int length = dfs(nums, i+1, seq) + 1;
                            maxLength = Math.max(maxLength, length);
                            seq.remove(seq.size()-1);
                        }
                    }
                    else {
                        if (nums[i] - beforeNum > 0){
                            seq.add(nums[i]);
                            int length = dfs(nums, i+1, seq) + 1;
                            maxLength = Math.max(maxLength, length);
                            seq.remove(seq.size()-1);
                        }
                    }
                }
            }
            return maxLength;
        }
    }

    /**
     * 100.00%
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n<2){
            return n;
        }
        //int[] up = new int[n];
        //int[] down = new int[n];
        //up[0] = 1;
        //down[0] = 1;
        int up = 1;
        int down = 1;
        for (int i=1; i<n; i++){
            if (nums[i] > nums[i-1]){
                up = Math.max(up, down + 1);
                //up[i] = Math.max(up[i-1], down[i-1]+1);
                //down[i] = down[i-1];
            }
            else if (nums[i] < nums[i-1]){
                down = Math.max(down, up + 1);
                //up[i] = up[i-1];
                //down[i] = Math.max(down[i-1], up[i-1]+1);
            }
            //else {
            //    up[i] = up[i-1];
            //    down[i] = down[i-1];
            //}
        }
        return Math.max(up, down);
        //return Math.max(up[n-1], down[n-1]);
    }

    /**
     * 100.00%
     * @param nums
     * @return
     */
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        WiggleSubsequence0376 wiggleSubsequence0376 = new WiggleSubsequence0376();
        //int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        //int[] nums = new int[]{1,7,4,9,2,5};
        //int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int[] nums = new int[]{0,0};
        System.out.println(wiggleSubsequence0376.wiggleMaxLength(nums));
    }
}
