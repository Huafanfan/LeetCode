package hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int longestSequence = 0;
        for (int num : set){
            if (!set.contains(num-1)){
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)){
                    curNum++;
                    curLength++;
                }
                longestSequence = Math.max(longestSequence, curLength);
            }
        }
        return longestSequence;
    }
}
