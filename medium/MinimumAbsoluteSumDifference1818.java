package medium;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0;
        int maxn = 0;
        for (int i=0; i<n; i++){
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + abs) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n){
                maxn = Math.max(maxn, abs - (rec[j] - nums2[i]));
            }
            if (j > 0){
                maxn = Math.max(maxn, abs - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target){
        int low = 0, high = rec.length - 1;
        if (rec[high] < target){
            return high + 1;
        }
        while (low < high){
            int mid = (high - low) /2 + low;
            if (rec[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}
