package neetcode.twopointers;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/25 11:00
 */
public class TwoSumiiInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            } else if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
