package byteDance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int length = 1, n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] queue = new int[n + 1];
        queue[length] = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] > queue[length]){
                queue[++length] = nums[i];
            }
            else {
                int left = 0;
                int right = length;
                while (left < right){
                    int mid = (right - left + 1) / 2 + left;
                    if (queue[mid] < nums[i]){
                        left = mid;
                    }
                    else {
                        right = mid - 1;
                    }
                }
                queue[left+1] = nums[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{8,9,10,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }
}
