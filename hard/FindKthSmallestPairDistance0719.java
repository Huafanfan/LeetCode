package hard;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/15 10:08
 */
public class FindKthSmallestPairDistance0719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n-1] - nums[0];
        while (l <= r){
            int m = l + (r -l)/2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > m) {
                    i++;
                }
                cnt += j - i;
            }
            //for (int j=0; j<n; j++){
            //    int i = binarySearch(nums, j, nums[j] - m);
            //    cnt += j - i;
            //}
            if (cnt >= k){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int binarySearch(int[] nums, int r, int target){
        int l = 0;
        while (l < r){
            int m = l + (r -l)/2;
            if (nums[m] < target){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
