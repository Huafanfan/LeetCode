package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/16 11:11
 */
public class KDiffPairsInAnArray0532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int num : nums){
            // k确定，只往Set中存数对中较小的数，一定不会重复。
            if (visited.contains(num - k)){
                ans.add(num - k);
            }
            if (visited.contains(num + k)){
                ans.add(num);
            }
            visited.add(num);
        }
        return ans.size();
    }

    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, j = 0, ans = 0;
        for (int i=0; i<n; i++){
            if (i == 0 || nums[i] != nums[i-1]){
                while (j < n && (nums[j] < nums[i] + k || j <= i)){
                    j++;
                }
                if (j < n && nums[j] == nums[i] + k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
