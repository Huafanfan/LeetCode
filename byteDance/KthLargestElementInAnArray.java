package byteDance;

import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return fastSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int fastSort(int[] nums, int left, int right, int k){
        if (left > right){
            return k;
        }
        int index = partition(nums, left, right);
        if (index == k){
            return nums[k];
        }
        else if (index < k){
            return fastSort(nums, index + 1, right, k);
        }
        else {
            return fastSort(nums, left, index - 1, k);
        }
    }

    public int partition(int[] nums, int left, int right){
        int randIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, randIndex, left);
        int lt = left;
        int candidate = nums[left];
        for (int i=left+1; i<=right; i++){
            if (nums[i] <= candidate){
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargestElementInAnArray.findKthLargest(nums, 4));
    }
}
