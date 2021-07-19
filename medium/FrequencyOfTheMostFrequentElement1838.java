package medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int sum = 0;
        int maxLength = 1;
        while (right < nums.length){
            sum += (long) (nums[right] - nums[right-1]) * (right - left);
            while (sum > k){
                sum -= nums[right] - nums[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement1838 frequencyOfTheMostFrequentElement1838 = new FrequencyOfTheMostFrequentElement1838();
        int[] nums = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        System.out.println(frequencyOfTheMostFrequentElement1838.maxFrequency(nums, 3056));
    }
}
